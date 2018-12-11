package com.example.UserProfile.controller;

import com.example.UserProfile.domain.UserProfile;


import com.example.UserProfile.exception.UserProfileAlreadyExitsException;
import com.example.UserProfile.service.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserProfileControllerTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MockMvc mockMvc;
    private UserProfile user;

    @MockBean
    private UserProfileService userService;

    @InjectMocks
    private UserProfileController userController;

    private List<UserProfile> list=null;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
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
        List<UserProfile> list = new ArrayList<>();

    }

    @Test
    public void saveUser() throws Exception {
        when(userService.saveUserProfile(any())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/sc200/userProfile")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isNotImplemented())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void saveUserFailure() throws Exception {
        when(userService.saveUserProfile(any())).thenThrow(UserProfileAlreadyExitsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/sc200/userProfile")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isNotImplemented())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getAllUserProfile() throws Exception {
        when(userService.getAllUserProfiles()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/sc200/userProfile")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }




    @Test
    public void getUserbyId() throws Exception {
        when(userService.searchUserProfileById("1@gmail.com")).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/sc200/userProfile/1@gmail.com")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }



    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
