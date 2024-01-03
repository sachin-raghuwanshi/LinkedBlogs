package com.programmers.blogwebsite.services;

import com.programmers.blogwebsite.entity.User;
import com.programmers.blogwebsite.exceptions.ResourceNotfoundException;
import com.programmers.blogwebsite.payloads.UserDto;
import com.programmers.blogwebsite.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserServices{
    private UserRepo userRepo;
    private ModelMapper modelMapper;
    @Autowired
    UserServiceImplementation(UserRepo userRepo, ModelMapper modelMapper) {

        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = DtotoUser(userDto);
        User savedUser = userRepo.save(user);
        return UsertoDto(savedUser);
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotfoundException("User", "Id", userId));
        userRepo.delete(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotfoundException("User", "Id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User userUpdated = userRepo.save(user);
        UserDto userDtoUpdated = UsertoDto(userUpdated);
        return userDtoUpdated;
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotfoundException("User", "Id", userId));
        return UsertoDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> list = userRepo.findAll();
        List<UserDto> listDto = new ArrayList<>();
        for(User user: list) {
            listDto.add(UsertoDto(user));
        }
        return listDto;
    }
    public User DtotoUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        return user;
    } public UserDto UsertoDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
