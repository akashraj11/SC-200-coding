//package com.stackroute.challengecreator.repository;
//
//import com.stackroute.challengecreator.domain.Challenge;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ChallengeRepositoryTest {
//
//    @Autowired
//    ChallengeRepository challengeRepository;
//    Challenge challenge;
//
//    @Before
//    public void setUp() throws Exception {
//
//        challenge = new Challenge();
//        challenge.setId(1);
//        challenge.setChallengeDesc("challangedesc");
//        challenge.setChallengeTitle("challengetitle");
//        challenge.setConstraints("constraints");
//        challenge.setInputFormat("Inputformat");
//        challenge.setProblemStat("problemstatement");
//        challenge.setProgLang("java");
//        challenge.setMaxScore(100);
//        challenge.setRating(3.2);
//        challenge.setMaxRuntime(34);
//        challenge.setSolutionUrl("solutionurl");
//        challenge.setLevel(3);
//
//    }
//
//    @Test
//    public void testSaveChallenge(){
//        challengeRepository.save(challenge);
//        Challenge fetchChallenges = challengeRepository.findById(challenge.getId()).get();
//        Assert.assertEquals(1,fetchChallenges.getId());
//    }
//
//
//    @Test
//    public void testSaveChallengeFailure(){
//
//    }
//
//    @Test
//    public void testGetallChallenges(){
//
//    }
//
//    @Test
//    public void testUpdateChallengesbyId(){
//
//    }
//
//    @Test
//    public void testDeleteChallenges(){
//
//
//    }
//}