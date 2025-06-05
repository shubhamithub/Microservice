package com.example.Hotel_Service.service;

import com.example.Hotel_Service.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    Hotel  getById(String id);

    List<Hotel> getAll();
}
