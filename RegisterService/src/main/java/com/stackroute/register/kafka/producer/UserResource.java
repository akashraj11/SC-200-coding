package com.stackroute.register.kafka.producer;

import com.stackroute.register.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "userProfile";
      public void putIntoTopic(User user){
          kafkaTemplate.send(TOPIC,user);
          System.out.println("we have executted send");
      }
}
