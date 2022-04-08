package com.h2demo.RestWithH2Example.RestApi.exception;

public class UserNotFoundException  extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
