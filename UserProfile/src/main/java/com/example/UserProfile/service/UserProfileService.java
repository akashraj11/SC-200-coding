package com.example.UserProfile.service;

import com.example.UserProfile.domain.Challenge;
import com.example.UserProfile.domain.UserProfile;
import com.example.UserProfile.exception.UserProfileAlreadyExitsException;
import com.example.UserProfile.exception.UserProfileNotFoundException;

import java.util.List;

public interface UserProfileService {


   // UserProfile updateUserProfileById(int id, UserProfile userprofile);

    List<UserProfile> getAllUserProfiles();
    UserProfile saveUserProfile(UserProfile userProfile) throws UserProfileAlreadyExitsException;
    UserProfile searchUserProfileById(String id) throws UserProfileNotFoundException;
    UserProfile updateuserProfileById(String id,UserProfile userProfile) throws UserProfileNotFoundException;
    UserProfile updateCreateChallengeToProfileById(String id, Challenge challenge) throws UserProfileNotFoundException;
    UserProfile updateAttemptChallengeToProfileById(String id,Challenge challenge) throws  UserProfileNotFoundException;
    UserProfile updateUpvoteChallengeToProfileById(String id,Challenge challenge) throws  UserProfileNotFoundException;
    UserProfile updateDownvoteChallengeToProfileById(String id,Challenge challenge) throws  UserProfileNotFoundException;
    boolean deleteUserProfilebyId(String id);
}
