package com.example.User_Service.service.Impl;

import com.example.User_Service.entity.User;
import com.example.User_Service.exception.ResourceNotFoundException;
import com.example.User_Service.repository.UserRepository;
import com.example.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User savedUser(User user) {
        //generate unique userId
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getById(String userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User With given id is not found : " + userId));
    }
}
