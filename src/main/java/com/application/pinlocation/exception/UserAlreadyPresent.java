package com.application.pinlocation.exception;

public class UserAlreadyPresent extends RuntimeException{
    public UserAlreadyPresent(String message){
        super(message);
    }
}
