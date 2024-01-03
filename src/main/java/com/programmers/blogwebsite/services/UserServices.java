package com.programmers.blogwebsite.services;

import com.programmers.blogwebsite.payloads.UserDto;

import java.util.List;

public interface UserServices {
    public UserDto createUser(UserDto userDto);
    public void deleteUser(int userId);
    public UserDto updateUser(UserDto userDto, int userId);
    public UserDto getUserById(int userId);
    public List<UserDto> getAllUsers();
}
