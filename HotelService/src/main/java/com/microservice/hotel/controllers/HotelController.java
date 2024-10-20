package com.microservice.hotel.controllers;

import com.microservice.hotel.entities.Hotel;
import com.microservice.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/hotel")
public class HotelController
{
    @Autowired
    HotelService hotelService;

    //Create
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        Hotel newHotel = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    //Get All
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok().body(hotels);

    }

    //Get Hotel By id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable String hotelId){
        Hotel hotel = hotelService.getById(hotelId);
        return ResponseEntity.ok().body(hotel);
    }
}
