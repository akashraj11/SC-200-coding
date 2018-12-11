package com.stackroute.register.kafka.producer;

import com.stackroute.register.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "test5";

//    @PostMapping("user")
//    public ResponseEntity<?> addUser(@RequestBody User user) {
//        ResponseEntity responseEntity;
//        kafkaTemplate.send(TOPIC,user);
//        responseEntity=new ResponseEntity<String>("Successfully Added", HttpStatus.CREATED);
//        return responseEntity;
//    }


      public void putIntoTopic(User user){
          System.out.println("inside putIntotOPIC"+user);
          //sending data to kafka topic named as test5
          kafkaTemplate.send(TOPIC,user);
          System.out.println("we have executted send");
      }
}
