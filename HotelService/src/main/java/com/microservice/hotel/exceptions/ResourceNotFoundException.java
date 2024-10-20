package com.microservice.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }

    public ResourceNotFoundException(){
        super("Resource Not Found !!");
    }
}