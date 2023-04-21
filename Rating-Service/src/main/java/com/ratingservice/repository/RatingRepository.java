package com.ratingservice.repository;

import com.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {
    //custom methods
    List<Rating> findByUserId(String usedId);

    List<Rating> findByHotelId(String hotelId);
}
