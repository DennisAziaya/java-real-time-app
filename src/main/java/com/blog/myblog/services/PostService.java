package com.blog.myblog.services;

import com.blog.myblog.payload.PostDto;
import com.blog.myblog.payload.PostResponse;

import java.util.List;

public interface PostService {
    //Create Post
    PostDto createPost(PostDto postDto);

    //List Posts
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    //Get post by ID
    PostDto getPostById(Long id);

    // Update Post
    PostDto updatePost( PostDto postDto, Long id);

    // Delete Post
    void deletePostById(Long id);
}
