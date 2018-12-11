package com.example.UserProfile.controller;

import com.example.UserProfile.domain.Challenge;
import com.example.UserProfile.domain.UserProfile;
import com.example.UserProfile.exception.UserProfileAlreadyExitsException;
import com.example.UserProfile.kafka.producer.UserResource;
import com.example.UserProfile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping(value = "/sc200/userProfile")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin
public class UserProfileController {

    private UserProfileService userProfileService;


    @Autowired
    UserResource userResource;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;

    }

    @PostMapping("")
    public ResponseEntity<?> saveUserProfile(@Valid @RequestBody UserProfile userProfile){
        ResponseEntity responseEntity;
              try {
                  userProfileService.saveUserProfile(userProfile);
                 userResource.putIntoTopic(userProfile);

                  responseEntity = new ResponseEntity<String>("userProfile.saveUser", HttpStatus.CREATED);
              }
              catch(UserProfileAlreadyExitsException e){
                  responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_IMPLEMENTED);
              }
              catch (Exception ex){
                  responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);
              }

        return responseEntity;
    }

    @GetMapping()
    public ResponseEntity<?> getAllUserProfiles() {
        return new ResponseEntity<List<UserProfile>>(userProfileService.getAllUserProfiles(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> searchById(@PathVariable("id") String id) {
       ResponseEntity responseEntity;
      try{

           UserProfile userProfile=userProfileService.searchUserProfileById(id);
         responseEntity= new ResponseEntity<UserProfile>(userProfile,HttpStatus.OK);
      }catch (Exception e){
           responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
      }
       return responseEntity;

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id){
        ResponseEntity responseEntity;

           if (userProfileService.deleteUserProfilebyId(id)==true) {
               responseEntity = new ResponseEntity<String>("userProfile-controller.deleteUser", HttpStatus.OK);

           }
           else{
               responseEntity= new ResponseEntity<String>("userProfile-controller.noUser",HttpStatus.NOT_FOUND);
           }
        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateuserProfileById(@Valid@RequestBody UserProfile userProfile ,@PathVariable("id") String id){
        ResponseEntity responseEntity;
       try {
           UserProfile updatedProfile = userProfileService.updateuserProfileById(id,userProfile);
           responseEntity = new ResponseEntity<UserProfile>(updatedProfile, HttpStatus.OK);

       }catch (Exception e){
            responseEntity =new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
       }
        return responseEntity;
    }
}