package com.stackroute.register.kafka.consumer;

import com.stackroute.register.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

//    @KafkaListener(topics = "Kafka_Example_json", group = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(User user) {
//        System.out.println("Consumed JSON Message: " + user);
//    }

//    @KafkaListener(topics = "test5", groupId = "group_id6", containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(@Payload User user) {
//        //fetching the data from created topic named as test5
//        System.out.println("Consumed JSON Message: " + user);
//        System.out.println("filtered data is "+user.getEmail());
//    }
}
