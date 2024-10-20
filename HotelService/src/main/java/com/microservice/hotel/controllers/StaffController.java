package com.microservice.hotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotelstaff")
public class StaffController {

    @GetMapping
    public String demo(){
        return "Hotel Staff Demo";
    }
}
