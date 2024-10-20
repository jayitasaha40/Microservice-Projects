package com.microservice.user.service;

import com.microservice.user.service.entities.Rating;
import com.microservice.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	 RatingService ratingService;

	@Test
	void createRating(){
		Rating rating = Rating.builder().rating(7).userId("Test").hotelId("TestHotel").build();
		ratingService.create(rating);
		System.out.println("TEST RATING CREATED");
	}

}
