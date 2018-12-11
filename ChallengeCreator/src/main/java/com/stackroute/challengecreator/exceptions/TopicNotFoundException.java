package com.stackroute.challengecreator.exceptions;

import com.stackroute.challengecreator.domain.Challenge;

public class TopicNotFoundException extends Exception {
    public TopicNotFoundException(Challenge challenge) {
        super(challenge.getTopic()+" Topic not found");
    }
}
