package com.microservice.hotel.services;

import com.microservice.hotel.entities.Hotel;

import java.util.List;

public interface HotelService
{
    //Create
    Hotel create(Hotel hotel);

    //Get All
    List<Hotel> getAll();

    //Get Hotel By Id
    Hotel getById(String hotelId);
}
