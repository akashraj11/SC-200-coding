package com.stackroute.kafka;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    UserRepository userRepository;
//    @KafkaListener(topics = "Kafka_Example_json", group = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(User user) {
//        System.out.println("Consumed JSON Message: " + user);
//    }

    @KafkaListener(topics = "userProfile", groupId = "loginService", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(@Payload User user) {


        User user1 = new User();
        //fetching the data from created topic named as test5
        System.out.println("Consumed JSON Message: " + user);
        System.out.println("filtered data is "+user.getUsername());
        System.out.println("filtered data is "+user.getPassword());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        userRepository.save(user1);

    }
}
