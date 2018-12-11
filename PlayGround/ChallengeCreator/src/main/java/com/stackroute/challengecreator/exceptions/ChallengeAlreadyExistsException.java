package com.stackroute.challengecreator.exceptions;

public class ChallengeAlreadyExistsException extends Exception {

    public ChallengeAlreadyExistsException(){
        super("challenge already exists");
    }
}
