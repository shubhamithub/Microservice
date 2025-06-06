package com.example.User_Service.service.Impl;

import com.example.User_Service.entity.Rating;
import com.example.User_Service.entity.User;
import com.example.User_Service.exception.ResourceNotFoundException;
import com.example.User_Service.repository.UserRepository;
import com.example.User_Service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User With given id is not found : " + userId));
        //fetching rating of the abpve user from RATING-SERVICE
        //http://localhost:8083/ratings/users/1eb75e00-4512-45b0-a284-a2eb178f016c
        ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/1eb75e00-4512-45b0-a284-a2eb178f016c", ArrayList.class);
        logger.info("{}",ratingsOfUser);
        user.setRating(ratingsOfUser);
        return user;
    }
}
