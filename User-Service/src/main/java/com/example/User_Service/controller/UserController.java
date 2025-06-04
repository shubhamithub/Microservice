package com.example.User_Service.controller;

import com.example.User_Service.entity.User;
import com.example.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.savedUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
}
