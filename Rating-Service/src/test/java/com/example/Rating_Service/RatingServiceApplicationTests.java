package com.example.Rating_Service;

import com.example.Rating_Service.entiy.Rating;
import com.example.Rating_Service.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RatingServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	/*@Test
	void creatingRating(){
		Rating rating= Rating.builder().rating(10).userId("").hotelId("").feedback("this hotel is very good").build();
		Rating rating1=ratingService.create(rating);
		System.out.println("new rating is create");

	}*/

}
