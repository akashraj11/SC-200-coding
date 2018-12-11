package com.example.upvote.Kafka.Producer;

import com.example.upvote.domain.Voting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class VotingResource {

    @Autowired
    private KafkaTemplate<String, Voting> kafkaTemplate;

    private static final String TOPIC = "votingTopic";
    // private static final String TOPIC2 = "votingtestchallenge";




    public void putIntoTopic(Voting voting){
        System.out.println("inside putIntotOPIC "+voting);
        kafkaTemplate.send(TOPIC,voting);
        // kafkaTemplate.send(TOPIC2,voting);
        System.out.println("we have executted send topic");
    }

}
