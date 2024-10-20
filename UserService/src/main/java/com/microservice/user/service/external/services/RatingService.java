package com.microservice.user.service.external.services;

import com.microservice.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService
{
    //POST - Create a New Rating
    @PostMapping("/rating")
    Rating create(Rating rating); //Rating create(Map<String,Object>  rating); But As swe already has defined entity we will use that

    //PUT
    @PutMapping("/rating/{ratingId}")
    Rating update(@PathVariable String ratingId, Rating rating);

    //DELETE
    @DeleteMapping("/rating/{ratingId}")
    void delete(@PathVariable String ratingId);

}
