package com.blog.myblog.payload;

import com.blog.myblog.entity.enums.Role;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private DateTimeFormat createTime;
    private Role role;
}
