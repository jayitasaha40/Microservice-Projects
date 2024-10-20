package com.microservice.rating.repository;

import com.microservice.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String>
{
    //Custom Functions - METHOD_NAMECOLUMNNAMEINCAMELCASE
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
