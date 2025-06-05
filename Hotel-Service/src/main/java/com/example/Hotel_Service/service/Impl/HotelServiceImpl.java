package com.example.Hotel_Service.service.Impl;

import com.example.Hotel_Service.entity.Hotel;
import com.example.Hotel_Service.exception.ResourceNotFoundException;
import com.example.Hotel_Service.repository.HotelRepository;
import com.example.Hotel_Service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getById(String id) {
        return hotelRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("hotel with given id not found..!!!"));
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
