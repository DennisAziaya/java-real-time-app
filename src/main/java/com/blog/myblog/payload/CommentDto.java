package com.blog.myblog.payload;
import lombok.Data;

import java.util.UUID;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
