package com.stackroute.kafka.producer;

import com.stackroute.domain.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private KafkaTemplate<String, Profile> kafkaTemplate;
    private static final String TOPIC="scoreTOPIC";

    public void putIntoTopic(Profile profile)
    {
        logger.info("inside topic: {}",TOPIC);
        kafkaTemplate.send(TOPIC,profile);
        logger.info("Sent!");
    }

}
