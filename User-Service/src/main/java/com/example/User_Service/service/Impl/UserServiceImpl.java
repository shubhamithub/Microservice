package com.example.User_Service.service.Impl;

import com.example.User_Service.entity.User;
import com.example.User_Service.exception.ResourceNotFoundException;
import com.example.User_Service.repository.UserRepository;
import com.example.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User savedUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getById(String userId) {
        return userRepository.findById(userId).orElseThrow(()->
                ResourceNotFoundException(""))
    }
}
