package com.stackroute.neo4jservice.kafka.consumer;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.nodes.User;
import com.stackroute.neo4jservice.domain.relation.Attempt;
import com.stackroute.neo4jservice.domain.relation.Post;
import com.stackroute.neo4jservice.domain.relation.TypeRelation;
import com.stackroute.neo4jservice.exception.ConceptNotFoundException;
import com.stackroute.neo4jservice.repository.noderepository.ChallengeRepository;
import com.stackroute.neo4jservice.repository.noderepository.UserRepository;
import com.stackroute.neo4jservice.service.nodeservice.ConceptService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.AttemptService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.PostService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Listener {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChallengeRepository challengeRepository;
    private PostService postService;
    private TypeService typeService;
    private ConceptService conceptService;
    private AttemptService attemptService;

    @Autowired
    public Listener(PostService postService, TypeService typeService, ConceptService conceptService, AttemptService attemptService) {
        this.postService = postService;
        this.typeService = typeService;
        this.conceptService = conceptService;
        this.attemptService=attemptService;
    }



    @KafkaListener(topics = "test5", groupId ="Neo4JUserProfile", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(@Payload User user) {

        user.setName(user.getFirstName()+user.getLastName());
        System.out.println("Consumed JSON Message: " + user);


        System.out.println("filtered data is "+user.getFirstName());
           User user1=new User();
        user1.setName(user.getFirstName()+user.getLastName());
        user1.setPreferredLang(user.getPreferredLang());
        user1.setUserId(user.getUserId());
        System.out.println(user1);
        User savedUser=userRepository.save(user1);
    }

        @KafkaListener(topics = "test-challenge",groupId ="Neo4JChallenge", containerFactory = "userKafkaListenerFactory")
        public void consumeJsonfromCreateChallenge(@Payload Challenge challenge) {
        Challenge challenge1=new Challenge();
       // System.out.println(challenge);
        challenge1.setChallengeTitle(challenge.getChallengeTitle());
        challenge1.setChallengeId(challenge.getChallengeId());
        challenge1.setTitle(challenge.getChallengeTitle());
        challenge1.setUserId(challenge.getUserId());
        challenge1.setChallengeStamp(challenge.getchallengeStamp());
        challenge1.setTopic(challenge.getTopic());
        challenge1.setLevel(challenge.getLevel());
            System.out.println(challenge);
            System.out.println(challenge1);

            System.out.println("create challenge json success");
            Concept searchedConcept=null;
            // create a post object from data
            Post post = new Post();
           // post.setId(99);

           // post.setDate(java.util.Calendar.getInstance().getTime());
          //  System.out.println("......in controller......."+post.getId());
          post.setChallenge(challenge1);
          User user2=new User();
          user2=userRepository.findById(challenge1.getUserId()).get();
          post.setUser(user2);
          // save this post object in database
            challengeRepository.save(challenge1);
          postService.savePost(post);
//
//            // write the logic to fefth the concept from the database based on the concept name
//            // Concept concept = repo.getConcept("name");
            String conceptName=challenge1.getTopic();
           // String res="array";
        Concept serchedConcept=new Concept();

         //  try {
           // Concept serchedConcept=new Concept();
            searchedConcept = conceptService.searchConceptByName(conceptName);
//
         //  }
//          // catch(ConceptNotFoundException e)
//           {
//               searchedConcept=conceptService.searchConceptByName(res);
//           }
//            // create a type relation to connect two nodes concept and challange
           TypeRelation tr = new TypeRelation();
           tr.setChallenge(challenge1);
         tr.setConcept(searchedConcept);
//            // System.out.println("....................in controller........"+ tr);
          TypeRelation savedTypeRelation=typeService.saveTypeRelation(tr);
           System.out.println("....................in controller......."+savedTypeRelation);


    }
    @KafkaListener(topics = "scoreTOPIC",groupId ="Neo4JAttempt1", containerFactory = "userKafkaListenerFactory")
    public void consumeJsonfromCreateChallenge1(@Payload Challenge challenge) {
        Challenge challenge1 = new Challenge();

       challenge1=  challengeRepository.findById(challenge.getChallengeId()).get();
//       challenge1.setChallengeTitle(challenge.getChallengeTitle());
//        challenge1.setChallengeId(challenge.getChallengeId());
//        challenge1.setTitle(challenge.getChallengeTitle());
       challenge1.setUserId(challenge.getUserId());
        //challenge1.setChallengeStamp(challenge.getchallengeStamp());
       // challenge1.setTopic(challenge.getTopic());
        System.out.println(challenge1);
//       // challengeRepository.save(challenge1);
//
       System.out.println("create challenge json success");
//
    // Post post = new Post();
        Attempt attempt = new Attempt();
        // post.setId(99);

        // post.setDate(java.util.Calendar.getInstance().getTime());
        //  System.out.println("......in controller......."+post.getId());
       attempt.setChallenge(challenge1);
     User user2 = new User();
      user2 = userRepository.findById(challenge1.getUserId()).get();
        attempt.setUser(user2);
//        // save this post object in database
//        //challengeRepository.save(challenge1);
       attemptService.saveAttempt(attempt);
    }
}
