package com.stackroute.neo4jservice.exception;

public class ConceptNotFoundException extends Exception {
    private String message;
    public ConceptNotFoundException(){};

    public ConceptNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
