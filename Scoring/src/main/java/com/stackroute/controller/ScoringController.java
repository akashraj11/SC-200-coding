package com.stackroute.controller;

import com.stackroute.domain.Profile;
import com.stackroute.kafka.producer.UserResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "")
@CrossOrigin
public class ScoringController {
    private static final Logger logger = LoggerFactory.getLogger(ScoringController.class);
    @Autowired
    private UserResource userResource;

    @PostMapping("")
    public ResponseEntity<Profile> sendProfile(@RequestBody Profile profile){
        logger.info("controller starts");
        userResource.putIntoTopic(profile);
        logger.info("inside controller");
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
