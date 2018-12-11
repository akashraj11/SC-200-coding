package com.stackroute.challengecreator.exceptions;

public class ChallengeNotFoundException extends Exception {

    private String message;

    public ChallengeNotFoundException() {
    }

    public ChallengeNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
