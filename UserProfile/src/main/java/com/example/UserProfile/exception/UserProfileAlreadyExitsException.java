package com.example.UserProfile.exception;

public class UserProfileAlreadyExitsException extends Exception
{

    private String message;

    public UserProfileAlreadyExitsException() {
    }

    public UserProfileAlreadyExitsException(String message) {
      super(message);
        this.message = message;
    }
}
