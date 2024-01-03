package com.programmers.blogwebsite.controllers;

import com.programmers.blogwebsite.payloads.UserDto;
import com.programmers.blogwebsite.services.UserServiceImplementation;
import com.programmers.blogwebsite.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUserDto =  userServices.createUser(userDto);
        //return createdUserDto;
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> UserDtoList =  userServices.getAllUsers();
        //return createdUserDto;
        return new ResponseEntity<>(UserDtoList, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        UserDto userDto =  userServices.getUserById(id);
        //return createdUserDto;
        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int id) {
        UserDto updatedUserDto =  userServices.updateUser(userDto, id);
        //return createdUserDto;
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userServices.deleteUser(id);
        //return createdUserDto;
        return new ResponseEntity(Map.of("Message", "User deleted successfully"),HttpStatus.OK);
    }


}
