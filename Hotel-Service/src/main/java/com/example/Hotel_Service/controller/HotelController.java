package com.example.Hotel_Service.controller;

import com.example.Hotel_Service.entity.Hotel;
import com.example.Hotel_Service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable String hotelId) {
        Hotel byId = hotelService.getById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel() {
        List<Hotel> all = hotelService.getAll();
        /*return ResponseEntity.status(HttpStatus.OK).body(all);*/
        return ResponseEntity.ok(all);
    }
}
