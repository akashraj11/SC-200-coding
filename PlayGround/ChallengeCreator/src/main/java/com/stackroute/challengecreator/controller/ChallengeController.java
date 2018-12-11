package com.stackroute.challengecreator.controller;

import com.stackroute.challengecreator.domain.Challenge;
import com.stackroute.challengecreator.domain.ChallengeObjL1;
import com.stackroute.challengecreator.domain.ChallengeObjL4;
import com.stackroute.challengecreator.exceptions.ChallengeAlreadyExistsException;
import com.stackroute.challengecreator.exceptions.ChallengeNotFoundException;
import com.stackroute.challengecreator.kafka.producer.ChallengeResource;
import com.stackroute.challengecreator.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/challengeAPI/v1")
@CrossOrigin
public class ChallengeController {

    private ChallengeService challengeService;
    private String exceptionMessage="";

    @Autowired
    ChallengeResource challengeResource;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }


    @PostMapping()
    public ResponseEntity<?> saveChallenge(@RequestBody @Valid Challenge challenge) throws ChallengeAlreadyExistsException {

        challengeResource.putIntoTopic(challenge);
        ChallengeObjL1 savedChallenge = challengeService.addChallengeObjL1(challenge);
        challengeResource.putIntoTopic2(savedChallenge);
        ResponseEntity responseEntity = new ResponseEntity(savedChallenge, HttpStatus.CREATED);

        return responseEntity;

    }

    @GetMapping()
    public ResponseEntity<?> getAllChallenges(){

        ResponseEntity responseEntity;
        List<ChallengeObjL1> challengesList = challengeService.getAllChallenges();
        responseEntity = new ResponseEntity<List<ChallengeObjL1>>(challengesList,HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> getChallengesBySearch(@RequestParam(value = "PL") String programmingLang, @RequestParam(value = "Topic") String topic,@RequestParam(value = "Lvl") Double level) throws ChallengeNotFoundException {

        ResponseEntity responseEntity;
        Map<String, ChallengeObjL4> challengesList = challengeService.getChallangesBySearch(programmingLang,topic,level);
        responseEntity =new ResponseEntity(challengesList,HttpStatus.OK);

        return responseEntity;
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> updateChallenge(@PathVariable(value = "id") int challengeId ,@Valid @RequestBody Challenge challenge ){
//
//        ResponseEntity responseEntity;
//        try {
//            Challenge savedChallenge = challengeService.updateChallenge(challengeId,challenge);
//            responseEntity = new ResponseEntity<Challenge>(savedChallenge, HttpStatus.OK);
//        }
//        catch (ChallengeNotFoundException ex){
//            responseEntity = new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
//        }
//
//        return responseEntity;
//    }
//
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getChallengeById(@PathVariable(value = "id") String challengeId){

        ResponseEntity responseEntity;
        try {
            Challenge savedChallenge = challengeService.getChallengeById(challengeId).get();
            responseEntity = new ResponseEntity<Challenge>(savedChallenge,HttpStatus.OK);
        }
        catch (ChallengeNotFoundException ex){
            responseEntity = new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<?> getChallengeByTitle(@PathVariable(value = "title") String challengeTitle){

        ResponseEntity responseEntity;
        try {
            List<Challenge> savedChallenge = challengeService.getChallengeByTitle(challengeTitle);
            responseEntity = new ResponseEntity(savedChallenge,HttpStatus.OK);
        }
        catch (ChallengeNotFoundException ex){
            responseEntity = new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
        }

        return responseEntity;
    }


    @GetMapping(value = "/range")
    public ResponseEntity<?> getChallengesByRating(@RequestParam(value = "LB",required = true) double lowerBound, @RequestParam(value = "UB", required = false) double upperBound){
        ResponseEntity responseEntity;
        try {
            List<Challenge> challengeList = challengeService.getChallengeByRating(lowerBound,upperBound);
            responseEntity = new ResponseEntity(challengeList,HttpStatus.OK);
        }
        catch (ChallengeNotFoundException ex){
            responseEntity = new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteChallenge(@PathVariable(value = "id") int challengeId){
//
//        ResponseEntity responseEntity;
//
//        try {
//            List<Challenge> challengeList = challengeService.deleteChallenge(challengeId);
//            responseEntity = new ResponseEntity(challengeList,HttpStatus.OK);
//        }
//        catch (ChallengeNotFoundException ex){
//            responseEntity = new ResponseEntity(exceptionMessage,HttpStatus.CONFLICT);
//        }
//
//        return responseEntity;
//    }
}