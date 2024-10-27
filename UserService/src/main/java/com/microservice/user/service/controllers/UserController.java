package com.microservice.user.service.controllers;

import com.microservice.user.service.entities.User;
import com.microservice.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    //create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    int retryCount = 1;
    //Get Single User By Id
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "ratingHotelLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        retryCount++;
        logger.info("Count: {}",retryCount);
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //Creating fall back method
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        ex.printStackTrace();
        User dummy = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some services are down")
                .userId("123")
                .build();
        return new ResponseEntity<>(dummy,HttpStatus.OK);
    }

    //Get All users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }
}
