package com.stackroute.challengecreator.exceptions;


public class LangNotFoundException extends Exception {
    public LangNotFoundException(String title) {
        super(title+" Programming Language not found");
    }
    public LangNotFoundException(int id) {
        super(id+" Programming Language not found");
    }
}
