package com.application.pinlocation.exception;

public class PinDetailsNotFoundException extends RuntimeException{
    public PinDetailsNotFoundException(String message){
        super(message);
    }
}
