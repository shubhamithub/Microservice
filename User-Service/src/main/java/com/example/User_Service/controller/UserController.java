package com.example.User_Service.controller;

import com.example.User_Service.entity.User;
import com.example.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.savedUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User useId = userService.getById(userId);
        return ResponseEntity.ok(useId);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> getAll = userService.getAllUser();
        return  ResponseEntity.ok(getAll);
    }
}
