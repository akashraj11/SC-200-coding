package com.stackroute.register.exceptions;

public class NullDetailsException extends Exception {
    private String message;

    public NullDetailsException() {
    }

    public NullDetailsException(String message) {
        super(message);
        this.message = message;
    }
}
