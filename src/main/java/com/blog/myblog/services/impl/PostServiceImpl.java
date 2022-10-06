package com.blog.myblog.services.impl;

import com.blog.myblog.entity.Post;
import com.blog.myblog.exceptions.ResourceNotFoundException;
import com.blog.myblog.payload.PostDto;
import com.blog.myblog.payload.PostResponse;
import com.blog.myblog.repository.PostRepository;
import com.blog.myblog.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Create Posts
    @Override
    public PostDto createPost(PostDto postDto) {

        //Convert Entity to DTO
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        //Convert Entity to DTO
        PostDto postResponse = mapToDTO(newPost);

        return postResponse;
    }

    //All Posts
    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        // Create pageable instance

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts = postRepository.findAll(pageable);
        //List<Post> posts = postRepository.findAll();

        // Get Content for page object
        List<Post> listOfPosts = posts.getContent();
        List<PostDto> content = listOfPosts.stream().map(this::mapToDTO).collect(Collectors.toList());
        //List<PostDto> content = listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLastPage(posts.isLast());

        return postResponse;
    }

    //Post By ID
    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    // Update Posts
    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatePost = postRepository.save(post);
        return mapToDTO(updatePost);
    }

    // Delete Post
    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
         postRepository.delete(post);
    }

    //Convert Entity to DTO
    private PostDto mapToDTO(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    // Convert DTO Entity
    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }


}
