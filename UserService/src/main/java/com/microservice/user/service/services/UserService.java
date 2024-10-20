package com.microservice.user.service.services;

import com.microservice.user.service.entities.User;

import java.util.List;

public interface UserService
{
    //Create a new user
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //Access user with id
    User getUser(String userId);

}
