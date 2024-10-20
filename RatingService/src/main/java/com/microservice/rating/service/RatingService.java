package com.microservice.rating.service;

import com.microservice.rating.entities.Rating;

import java.util.List;

public interface RatingService
{
    //Create
    Rating create(Rating rating);

    //GetAll
    List<Rating> getAll();

    //Get all BY ID

        //Get ALL BY User ID
        List<Rating> getByUserId(String userId);

        //Get By Hotel ID
        List<Rating> getByHotelId(String hotelId);
}
