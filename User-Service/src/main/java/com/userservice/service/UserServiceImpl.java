package com.userservice.service;

import com.userservice.entity.Hotel;
import com.userservice.exception.UserNotFoundException;
import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.externalservice.HotelService;
import com.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate  restTemplate;

    @Autowired
    private HotelService  hotelService;
/*
    @Autowired
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);*/

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        User  user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not available"));

        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/"+user.getUserId(), Rating[].class);
        log.info("{}",forObject);

        List<Rating>  ratings = Arrays.stream(forObject).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // Api call to hotel service to get the hotel
          //  ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
          //  log.info("Response status code {}",forEntity.getStatusCode());

            //Set the hotel to rating
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user ;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }


}
