package com.stackroute.challengecreator.kafka.producer;
import com.stackroute.challengecreator.domain.Challenge;
import com.stackroute.challengecreator.domain.ChallengeObjL1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeResource {
    @Autowired
    private KafkaTemplate<String, Challenge> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, ChallengeObjL1> kafkaTemplate2;
    private static final String TOPIC = "test-challenge";
    private static final String TOPIC1 = "test-challengeObjL1";
    //    @PostMapping("user")
//    public ResponseEntity<?> addUser(@RequestBody User user) {
//        ResponseEntity responseEntity;
//        kafkaTemplate.send(TOPIC,user);
//        responseEntity=new ResponseEntity<String>("Successfully Added", HttpStatus.CREATED);
//        return responseEntity;
//    }

    public void putIntoTopic(Challenge challenge){
        System.out.println("inside putIntoTOPIC"+challenge);
        kafkaTemplate.send(TOPIC,challenge);
        System.out.println("we have executed send");
    }

    public void putIntoTopic2(ChallengeObjL1 challengeObjL1){
        System.out.println("inside putIntoTOPIC"+challengeObjL1);
        kafkaTemplate2.send(TOPIC1,challengeObjL1);
        System.out.println("we have executed send");
    }
}

