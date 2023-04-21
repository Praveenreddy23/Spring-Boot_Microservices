package com.ratingservice.controller;

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService  ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("id") String userid){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getUserByUserId(userid));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("id") String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }
}
