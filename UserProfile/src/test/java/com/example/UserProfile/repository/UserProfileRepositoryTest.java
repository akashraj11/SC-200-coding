package com.example.UserProfile.repository;

import com.example.UserProfile.domain.UserProfile;
import com.example.UserProfile.exception.UserProfileAlreadyExitsException;
import com.example.UserProfile.exception.UserProfileNotFoundException;

import com.example.UserProfile.repository.*;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
//we will use db server
@RunWith(SpringRunner.class)
@DataMongoTest
public class UserProfileRepositoryTest {





    @Autowired
    UserProfileRepository userProfileRepository;
    UserProfile user;

    @Before
    public void setUp(){
        user = new UserProfile();
        user.setChallengeCreated(null);
        user.setEmail("1@gmail.com");
        user.setUserId("null");
        user.setChallengeUpvoted(null);
        user.setChallengeAttempted(null);
        user.setChallengeDownvoted(null);
        user.setDateOfBirth("20-07-1996");
        user.setFirstName("first");
        user.setLastName("last");
        user.setPhone( 9087654321L );
        user.setPreferredLang("java");
        user.setRanking(7);
        user.setUsername("user1");
        user.setScore(9.53);
    }

    @Test
    public void testSaveUser(){
        userProfileRepository.save(user);
        UserProfile fetchUserProfile = userProfileRepository.findById(user.getEmail()).get();
        Assert.assertEquals("user1",fetchUserProfile.getUsername());
    }

    @Test
    public void testSaveUserFailure(){
        userProfileRepository.save(user);
        UserProfile fetchUserProfile = userProfileRepository.findById(user.getEmail()).get();
        Assert.assertEquals(user,fetchUserProfile);
    }

}
