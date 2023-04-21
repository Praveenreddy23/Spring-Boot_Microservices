package com.userservice;

import com.userservice.entity.Rating;
import com.userservice.externalservice.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void CreateRating(){
		Rating rating= Rating.builder()
				.rate(9.5)
				.userId("")
				.hotelId("")
				.feedback("good")
				.build();
		Rating saveRating = ratingService.createRating(rating);


	}

}
