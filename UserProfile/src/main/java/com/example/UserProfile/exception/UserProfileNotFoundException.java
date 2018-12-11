package com.example.UserProfile.exception;

public class UserProfileNotFoundException extends Exception {

    String message;
    public UserProfileNotFoundException(String message) {
        super(message);
        this.message=message;

    }

}
