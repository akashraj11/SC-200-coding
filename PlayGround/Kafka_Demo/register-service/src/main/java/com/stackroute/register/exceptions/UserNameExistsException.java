package com.stackroute.register.exceptions;

public class UserNameExistsException extends Exception {

    private String message ;

    public UserNameExistsException(){

    }

    public UserNameExistsException(String message){
        super(message);
        this.message=message;
    }
}
