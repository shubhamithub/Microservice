package com.example.Rating_Service.service;

import com.example.Rating_Service.entiy.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
