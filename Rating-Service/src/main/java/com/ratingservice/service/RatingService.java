package com.ratingservice.service;

import com.ratingservice.entity.Rating;

import java.util.List;


public interface RatingService {

    //save
    Rating create(Rating rating);
//get all rating
    List<Rating> getRatings();
//get all by used id
    List<Rating> getUserByUserId(String usedId);
//get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);

}
