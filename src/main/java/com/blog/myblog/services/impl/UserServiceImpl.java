package com.blog.myblog.services.impl;

import com.blog.myblog.entity.User;
import com.blog.myblog.payload.UserDto;
import com.blog.myblog.repository.UserRepository;
import com.blog.myblog.services.UserService;

public class UserServiceImpl implements UserService {
    
    
    private UserRepository userRepository;
    
    @Override
    public UserDto createUser(UserDto userDto) {
//        userDto.set
        return null;
    }


    private UserDto mapToDTO(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setRole(user.getRole());
        userDto.setPassword(user.getPassword());
        //userDto.setCreateTime(user.getCreateTime());

        return userDto;
    }

    // Convert DTO Entity
    private User mapToEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return user;
    }
    
    
}
