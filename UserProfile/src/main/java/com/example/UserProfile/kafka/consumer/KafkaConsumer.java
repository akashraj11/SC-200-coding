package com.example.UserProfile.kafka.consumer;


import com.example.UserProfile.domain.Challenge;
import com.example.UserProfile.domain.UserId;
import com.example.UserProfile.domain.UserProfile;
import com.example.UserProfile.exception.UserProfileNotFoundException;
import com.example.UserProfile.repository.UserProfileRepository;
import com.example.UserProfile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.example.UserProfile.kafka.producer.UserResource;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    public UserProfileRepository userProfileRepository;
    public UserProfileService userProfileService;
    private UserResource userResource;
    private UserProfile userProfile;

    public KafkaConsumer() {
    }

    @Autowired
    public KafkaConsumer(UserProfileRepository userProfileRepository, UserProfileService userProfileService, UserResource userResource) {
        this.userProfileRepository=userProfileRepository;
        this.userProfileService=userProfileService;
        this.userResource=userResource;
    }


    @KafkaListener(topics = "test5", groupId = "group_id6", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(@Payload UserProfile user) {
        System.out.println("Consumed JSON Message: " + user);
        System.out.println("filtered data is "+user.getFirstName());
    }

    //listen to create challenge topic and update the database.

    @KafkaListener(topics = "test-challenge", groupId = "group_id7", containerFactory = "challengeKafkaListenerFactory")
    public void consumeJsonFromChallengeService(@Payload Challenge challenge) {

        Challenge challenge1= new Challenge();
        challenge1.setChallengeScore(challenge.getMaxScore());
        challenge1.setChallengeId(challenge.getChallengeId());
        challenge1.setChallengeTitle(challenge.getChallengeTitle());
        challenge1.setUserId(challenge.getUserId());
        challenge1.setMaxScore(challenge.getMaxScore());

        String userId=challenge.getUserId();
        try {
            userProfile = userProfileService.searchUserProfileById(userId);
            if(userProfile.getChallengeCreated()==null){
                List<Challenge> challenges = new ArrayList<>();
                challenges.add(challenge1);
                userProfile.setChallengeCreated(challenges);
            }
            else{
                List<Challenge> challenges = userProfile.getChallengeCreated();
                challenges.add(challenge1);
                userProfile.setChallengeCreated(challenges);
            }
            userProfileRepository.save(userProfile);
        }

        catch (UserProfileNotFoundException ex){
            ex.printStackTrace();
        }

        System.out.println(userProfile.getChallengeCreated());
              userProfileRepository.save(userProfile);
  }
  @KafkaListener(topics = "userProfile", groupId = "group_id8", containerFactory = "registrationKafkaListenerFactory")
    public void consumeJsonfromRegService(@Payload UserProfile userProfile) {

        System.out.println("Consumed JSON Message of UserProfile from RegService: " + userProfile);
        userProfile.setUserId(userProfile.getEmail());
        userResource.putIntoTopic(userProfile);

      userProfileRepository.save(userProfile);


    }

    //need to add kafka listener for scoring service

    @KafkaListener(topics = "scoreTOPIC",groupId = "group_id9",containerFactory ="scoringKafkaListenerFactory")
    public void consumeJsonFromScoringService(@Payload Challenge challenge) {

        System.out.println("Consumed JSON Message of challenge: " + challenge);
        System.out.println("filtered data is "+challenge.getChallengeId());

        try{
            UserProfile userProfile = userProfileService.searchUserProfileById(challenge.getUserId());
            userProfileService.updateAttemptChallengeToProfileById(challenge.getUserId(),challenge);
        }
        catch (UserProfileNotFoundException ex){
            ex.printStackTrace();
        }


    }

    // add the kafka topic for both upvoted and downvoted challenges

    @KafkaListener(topics="votingTopic",groupId = "group_id10",containerFactory = "votingKafkaListenerFactory")
    public void consumeJsonFromVotingService(@Payload Challenge challenge){
        try{

            if(challenge.isFlag()) {
                UserProfile userProfile = userProfileService.searchUserProfileById(challenge.getUserId());
                userProfileService.updateUpvoteChallengeToProfileById(challenge.getUserId(), challenge);
            }
            else{
                UserProfile userProfile = userProfileService.searchUserProfileById(challenge.getUserId());
                userProfileService.updateDownvoteChallengeToProfileById(challenge.getUserId(), challenge);
            }
        }
        catch (UserProfileNotFoundException ex){
            ex.printStackTrace();
        }
    }



}