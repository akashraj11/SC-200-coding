package com.stackroute.challengecreator.exceptions;

public class ChallengeNotFoundException extends Exception {

//    public ChallengeNotFoundException(String title) {
//        super(title+" Challenge not found");
//    }
//    public ChallengeNotFoundException(int id) {
//        super(id+" Challenge not found");
//    }
//    public ChallengeNotFoundException() {
//        super("challenge-exceptions.challengeNotF");
//    }

    private String message;

    public ChallengeNotFoundException() {
    }

    public ChallengeNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
