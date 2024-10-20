package com.microservice.rating.controllers;

import com.microservice.rating.entities.Rating;
import com.microservice.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/rating")
public class RatingController
{
    @Autowired
    private RatingService ratingService;

    //create
    @PostMapping
    public ResponseEntity<Rating> create( @RequestBody Rating rating){
        Rating newRating =ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
    }

    //Get All
    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        List<Rating> ratings = ratingService.getAll();
        return ResponseEntity.ok().body(ratings);
    }

    //Get All By User ID
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllByUserId(@PathVariable String userId){
        List<Rating> ratings = ratingService.getByUserId(userId);
        return ResponseEntity.ok().body(ratings);
    }

    //Get All By Hotel ID
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllByHotelId(@PathVariable String hotelId){
        List<Rating> ratings = ratingService.getByHotelId(hotelId);
        return ResponseEntity.ok().body(ratings);
    }
}
