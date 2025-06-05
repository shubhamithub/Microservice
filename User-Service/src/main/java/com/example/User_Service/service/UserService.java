package com.example.User_Service.service;

import com.example.User_Service.entity.User;

import java.util.List;


public interface UserService {

    User savedUser(User user);

    List<User> getAllUser();

    User getById(String userId);


}
