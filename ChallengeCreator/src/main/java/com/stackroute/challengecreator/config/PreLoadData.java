package com.stackroute.challengecreator.config;

import com.stackroute.challengecreator.domain.Challenge;
import com.stackroute.challengecreator.exceptions.ChallengeAlreadyExistsException;
import com.stackroute.challengecreator.service.ChallengeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class PreLoadData implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    private ChallengeService challengeService;

    public PreLoadData(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }


    @Override
    public void run(String... args) throws Exception {

//        Challenge challenge = new Challenge();
//        Challenge challenge1 = new Challenge();
//        Challenge challenge2 = new Challenge();
//        Challenge challenge3 = new Challenge();
//
//        challenge.setChallengeId("1");
//        challenge.setLevel(1);
//        challenge.setMaxRuntime(8);
//        challenge.setMaxScore(100);
//        challenge.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
//        challenge.setChallengeTitle("MovieCruer");
//        challenge.setBoilerPlateUrl("string");
//        challenge.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
//        challenge.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
//        challenge.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge.setUserId("dummy");
//        challenge.setProgrammingLang("java");
//        challenge.setTopic("Array");
//        challenge.setSolutionUrl("string");
//        challenge.setDownvotes(0);
//        challenge.setUpvotes(0);
//        challenge.setRating(0);
//
//        challenge1.setChallengeId("2");
//        challenge1.setLevel(2);
//        challenge1.setMaxRuntime(8);
//        challenge1.setMaxScore(100);
//        challenge1.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge1.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
//        challenge1.setChallengeTitle("MovieCruer1");
//        challenge1.setBoilerPlateUrl("string");
//        challenge1.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
//        challenge1.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
//        challenge1.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge1.setUserId("dummy2");
//        challenge1.setProgrammingLang("java");
//        challenge1.setTopic("Array");
//        challenge1.setSolutionUrl("string");
//        challenge1.setDownvotes(0);
//        challenge1.setUpvotes(0);
//        challenge1.setRating(0);
//
//        challenge2.setChallengeId("3");
//        challenge2.setLevel(1);
//        challenge2.setMaxRuntime(8);
//        challenge2.setMaxScore(100);
//        challenge2.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge2.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
//        challenge2.setChallengeTitle("MovieCruer2");
//        challenge2.setBoilerPlateUrl("string");
//        challenge2.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
//        challenge2.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
//        challenge2.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge2.setUserId("dummy3");
//        challenge2.setProgrammingLang("java");
//        challenge2.setTopic("Map");
//        challenge2.setSolutionUrl("string");
//        challenge2.setDownvotes(0);
//        challenge2.setUpvotes(0);
//        challenge2.setRating(0);
//
//        challenge3.setChallengeId("4");
//        challenge3.setLevel(2);
//        challenge3.setMaxRuntime(8);
//        challenge3.setMaxScore(100);
//        challenge3.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge3.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
//        challenge3.setChallengeTitle("MovieCruer3");
//        challenge3.setBoilerPlateUrl("string");
//        challenge3.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
//        challenge3.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
//        challenge3.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
//        challenge3.setUserId("dummy4");
//        challenge3.setProgrammingLang("java");
//        challenge3.setTopic("Array");
//        challenge3.setSolutionUrl("string");
//        challenge3.setDownvotes(0);
//        challenge3.setUpvotes(0);
//        challenge3.setRating(0);
//
//        challengeService.addChallengeObjL1(challenge);
//        challengeService.addChallengeObjL1(challenge1);
//        challengeService.addChallengeObjL1(challenge2);
//        challengeService.addChallengeObjL1(challenge3);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Challenge challenge = new Challenge();
        Challenge challenge1 = new Challenge();
        Challenge challenge2 = new Challenge();
        Challenge challenge3 = new Challenge();

        challenge.setChallengeId("1");
        challenge.setLevel(1);
        challenge.setMaxRuntime(8);
        challenge.setMaxScore(100);
        challenge.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
        challenge.setChallengeTitle("MovieCruer");
        challenge.setBoilerPlateUrl("string");
        challenge.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
        challenge.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
        challenge.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge.setUserId("dummy");
        challenge.setProgrammingLang("java");
        challenge.setTopic("Array");
        challenge.setSolutionUrl("string");
        challenge.setDownvotes(0);
        challenge.setUpvotes(0);
        challenge.setRating(0);

        challenge1.setChallengeId("2");
        challenge1.setLevel(2);
        challenge1.setMaxRuntime(8);
        challenge1.setMaxScore(100);
        challenge1.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge1.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
        challenge1.setChallengeTitle("MovieCruer1");
        challenge1.setBoilerPlateUrl("string");
        challenge1.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
        challenge1.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
        challenge1.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge1.setUserId("dummy2");
        challenge1.setProgrammingLang("java");
        challenge1.setTopic("Array");
        challenge1.setSolutionUrl("string");
        challenge1.setDownvotes(0);
        challenge1.setUpvotes(0);
        challenge1.setRating(0);

        challenge2.setChallengeId("3");
        challenge2.setLevel(1);
        challenge2.setMaxRuntime(8);
        challenge2.setMaxScore(100);
        challenge2.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge2.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
        challenge2.setChallengeTitle("MovieCruer2");
        challenge2.setBoilerPlateUrl("string");
        challenge2.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
        challenge2.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
        challenge2.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge2.setUserId("dummy3");
        challenge2.setProgrammingLang("java");
        challenge2.setTopic("Map");
        challenge2.setSolutionUrl("string");
        challenge2.setDownvotes(0);
        challenge2.setUpvotes(0);
        challenge2.setRating(0);

        challenge3.setChallengeId("4");
        challenge3.setLevel(2);
        challenge3.setMaxRuntime(8);
        challenge3.setMaxScore(100);
        challenge3.setInputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge3.setConstraints("1 <= T <= 20 1 <= T <= 200 1 <= T <= 2000 1 <= T <= 299990 ");
        challenge3.setChallengeTitle("MovieCruer3");
        challenge3.setBoilerPlateUrl("string");
        challenge3.setChallengeStamp("Your task is to find the city number in which Dory will find Nemo.");
        challenge3.setChallengeStatement("First, she gets the mark from a city, then uses it to mark the next city she visits, gets next mark from next city ");
        challenge3.setOutputFormat("First input line contains number of test cases T Your task is to find the city number in which Dory will find Nemo.Your task is to find the city number in which Dory will find Nemo.");
        challenge3.setUserId("dummy4");
        challenge3.setProgrammingLang("java");
        challenge3.setTopic("Array");
        challenge3.setSolutionUrl("string");
        challenge3.setDownvotes(0);
        challenge3.setUpvotes(0);
        challenge3.setRating(0);

        try {
            challengeService.addChallengeObjL1(challenge);
        } catch (ChallengeAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            challengeService.addChallengeObjL1(challenge1);
        } catch (ChallengeAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            challengeService.addChallengeObjL1(challenge2);
        } catch (ChallengeAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            challengeService.addChallengeObjL1(challenge3);
        } catch (ChallengeAlreadyExistsException e) {
            e.printStackTrace();
        }
    }


}

