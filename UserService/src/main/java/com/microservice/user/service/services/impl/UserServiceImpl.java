package com.microservice.user.service.services.impl;

import com.microservice.user.service.entities.Hotel;
import com.microservice.user.service.entities.Rating;
import com.microservice.user.service.entities.User;
import com.microservice.user.service.external.services.HotelService;
import com.microservice.user.service.repositories.UserRepository;
import com.microservice.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given Id not present within the DB: "+userId));

        //Fetch Rating Via RATING SERVICE's URL
        Rating[] ratingsObject = restTemplate.getForObject("http://RATINGSERVICE/rating/users/"+user.getUserId(),Rating[].class);
        logger.info("{}", (Object) ratingsObject);

        assert ratingsObject != null;
        List<Rating> ratings = Arrays.stream(ratingsObject).toList();

        //Fetch hotel's details using HOTEL SERVICE and Set to Rating
        List<Rating> ratingsList = ratings.stream().map(rating -> {
            //Get Hotel Info Using each Hotel Id of Rating
            //http://localhost:8082/hotel/562f6db7-04a3-4292-8102-a54cc99cfa6c

            String hotelId = rating.getHotelId();
//            ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+hotelId, Hotel.class);
//            Hotel hotel = hotelResponseEntity.getBody();

            Hotel hotel = hotelService.getHotel(hotelId); //Instead of Upper 2 lines!!

            //logger.info("Response Status Code: {}",hotelResponseEntity.getStatusCode());

            //Set the Hotel Info to Rating
            rating.setHotel(hotel);

            //Return Rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingsList);
        return user;
    }
}
