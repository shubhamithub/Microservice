package com.example.User_Service.external.services;

import com.example.User_Service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    //Post
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);

    // Put
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating rating);

    //Delete
    @DeleteMapping("/ratings/{ratingId}")
    public void DeleteRating(@PathVariable String ratingId, String rating);

}
