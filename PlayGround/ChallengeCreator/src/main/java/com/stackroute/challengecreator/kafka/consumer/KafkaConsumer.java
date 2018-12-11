package com.stackroute.challengecreator.kafka.consumer;


import com.stackroute.challengecreator.domain.Challenge;
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

    @KafkaListener(topics = "test-challenge", groupId = "group_id6", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(@Payload Challenge challenge) {
        System.out.println("Consumed JSON Message: " + challenge);
        System.out.println("filtered data is "+challenge.getChallengeTitle());
    }
}