package com.example.User_Service.controller;

import com.example.User_Service.entity.User;
import com.example.User_Service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.savedUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User useId = userService.getById(userId);
        return ResponseEntity.ok(useId);
    }

    //creating fallback method for circuitbreaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        logger.info("FallBack is executed because service is down : ", ex.getMessage());
        User user = User.builder()
                .userId(userId)
                .email("dummyuser@gmail.com")
                .name("1997")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> getAll = userService.getAllUser();
        return ResponseEntity.ok(getAll);
    }
}
