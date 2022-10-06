package com.blog.myblog.controllers;

import com.blog.myblog.payload.CommentDto;
import com.blog.myblog.payload.PostDto;
import com.blog.myblog.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@RequestMapping("/post/{postId}/comments")
public class CommentController {
    private CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //Create post
    @PostMapping("/add")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name = "postId") long postId,
                                                    @RequestBody CommentDto commentDto
    ) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {

        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/{commentId}/update")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId,
            @RequestBody CommentDto commentDto) {
        CommentDto commentResponse = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}/delete")
    public ResponseEntity<String> deleteComment(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "commentId") Long commentId){
        commentService.deleteCommentById(postId, commentId);
        return new ResponseEntity<>("Comment successfully deleted", HttpStatus.OK);


    }

}
