package com.blog.myblog.services;

import com.blog.myblog.payload.CommentDto;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest);

    void deleteCommentById(Long postId, Long commentId);
}
