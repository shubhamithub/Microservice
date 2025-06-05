package com.example.Hotel_Service.repository;

import com.example.Hotel_Service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
