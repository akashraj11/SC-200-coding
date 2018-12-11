package com.stackroute.register.exceptions;

public class NoSuchUserException extends Exception {
    private String message;

    public NoSuchUserException() {
    }

    public NoSuchUserException(String message) {
        super(message);
        this.message = message;
    }
}
