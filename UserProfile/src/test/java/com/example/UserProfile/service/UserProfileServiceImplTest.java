package com.example.UserProfile.service;

import com.example.UserProfile.domain.UserProfile;
import com.example.UserProfile.exception.UserProfileAlreadyExitsException;
import com.example.UserProfile.exception.UserProfileNotFoundException;

import com.example.UserProfile.repository.UserProfileRepository;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


import org.mockito.Mock;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserProfileServiceImplTest {


    UserProfile user;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Mock
    UserProfileRepository userProfileRepository;

    @InjectMocks
    UserProfileServiceImpl userProfileService;
    List<UserProfile> list = null;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);


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
    public void saveUserTest() throws Exception {
        when(userProfileRepository.save((UserProfile) any())).thenReturn(user);
        UserProfile savedUser = userProfileService.saveUserProfile(user);
        Assert.assertEquals(user, savedUser);
        verify(userProfileRepository, times(1)).save(user);
    }

    @Test
    public void getAllUser() throws UserProfileNotFoundException {
        userProfileRepository.save(user);
        when(userProfileRepository.findAll()).thenReturn(list);
        List<UserProfile> userList = userProfileService.getAllUserProfiles();
        Assert.assertEquals(list, userList);
        verify(userProfileRepository, times(1)).findAll();
    }

    @Test(expected = UserProfileNotFoundException.class)
    public void searchById() throws Exception {
        UserProfile user1 = new UserProfile("1@gmail.com","null","first","last","user1","20-07-1996",9087654321L,12.3,7,"java",null,null,null,null);
        when(userProfileRepository.save(user1)).thenReturn(user1);
        UserProfile savedUserProfile = userProfileService.saveUserProfile(user1);
        Optional<UserProfile> returnMovie = Optional.empty();
        when(userProfileRepository.findById(any())).thenReturn(returnMovie);
        Optional<UserProfile> returnServiceMovie = Optional.ofNullable(userProfileService.searchUserProfileById(user1.getUsername()));
        Assert.assertEquals(returnMovie, returnServiceMovie);
    }


    @Test
    public void updatebyId() throws Exception {
        try {
            UserProfile user1 = new UserProfile("1@gmail.com","null","first","last","user1","20-07-1996",9087654321L,12.3,7,"java",null,null,null,null);
            when(userProfileRepository.save(user1)).thenReturn(user1);
            UserProfile savedUserProfile1 = userProfileService.saveUserProfile(user1);
            UserProfile user2 = new UserProfile("2@gmail.com","null","second","last","user2","20-07-1997",9087654301L,12.9,4,"java",null,null,null,null);
            when(userProfileRepository.save(user2)).thenReturn(user2);
            UserProfile savedUserProfile2 = userProfileService.saveUserProfile(user2);
            List<UserProfile> newList = new ArrayList<>();
            newList = userProfileService.getAllUserProfiles();
            System.out.println(newList.get(0).getUsername());


        } catch (Exception ex) {
            logger.error(ex.getMessage());
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}


