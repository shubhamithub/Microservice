package com.example.Rating_Service.controller;

import com.example.Rating_Service.entiy.Rating;
import com.example.Rating_Service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        Rating createRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> getAll = ratingService.getAllRatings();
        return ResponseEntity.status(HttpStatus.OK).body(getAll);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        List<Rating> response = ratingService.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratings=ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratings);

    }
}
