package com.example.Hotel_Service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffsController {

    @GetMapping
    public ResponseEntity<List<String>> getStaffs() {
        List<String> staffs = new ArrayList<>(Arrays.asList("shubham", "pandey", "mishra", "gautam"));
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }
}
