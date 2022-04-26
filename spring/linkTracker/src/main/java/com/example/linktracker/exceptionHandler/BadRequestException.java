package com.example.linktracker.exceptionHandler;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
