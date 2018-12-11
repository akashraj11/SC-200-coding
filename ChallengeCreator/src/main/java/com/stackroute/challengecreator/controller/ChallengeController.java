package com.stackroute.challengecreator.controller;

import com.stackroute.challengecreator.domain.Challenge;
import com.stackroute.challengecreator.domain.ChallengeObjL1;
import com.stackroute.challengecreator.domain.ChallengeObjL4;
import com.stackroute.challengecreator.exceptions.ChallengeAlreadyExistsException;
import com.stackroute.challengecreator.exceptions.ChallengeNotFoundException;
import com.stackroute.challengecreator.exceptions.LangNotFoundException;
import com.stackroute.challengecreator.exceptions.TopicNotFoundException;
import com.stackroute.challengecreator.kafka.producer.ChallengeResource;
import com.stackroute.challengecreator.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    //Added for Search
    @GetMapping(value="search/{topic}")
    public ResponseEntity<?> getChallengesByTopic(@Valid @PathVariable(value="topic") String topic){
        ResponseEntity responseEntity=null;
        System.out.println("in get mapping with topic");
        try {
            List<Challenge> challengeList= challengeService.getChallengesByTopicReg(topic);

            responseEntity=new ResponseEntity<List<Challenge>>(challengeList, HttpStatus.OK);
            System.out.println("returned challenges with topic "+topic);

        }
        catch (TopicNotFoundException tne){
            System.out.println(tne.getStackTrace());
        }

        return responseEntity;
    }
    @GetMapping(value="suggestion/{topic}")
    public ResponseEntity<?> getChallengeSuggestion(@Valid @PathVariable(value="topic") String topic){
        ResponseEntity responseEntity=null;
        System.out.println("in get mapping");
        try {
            List<Challenge> challengeList= challengeService.getChallengesByTopicReg(topic);
            System.out.println(challengeList.size());
            List<Challenge> suggestion=new ArrayList<>();
            int n=challengeList.size()>20?20:challengeList.size();
            suggestion=challengeList.subList(0,n);
            responseEntity=new ResponseEntity<List<Challenge>>(suggestion, HttpStatus.OK);
            System.out.println("returned auto complete challenges");

        }
        catch (TopicNotFoundException tne){
            System.out.println(tne.getStackTrace());
        }

        return responseEntity;
    }
    @GetMapping(value="search/{programmingLang}/{topic}")
    public ResponseEntity<?> getChallengeByLangAndTopic(@Valid @PathVariable(value="topic") String topic,
                                                        @PathVariable(value="programmingLang") String programmingLang) {
        List<Challenge> challengesByLang;
        ResponseEntity responseEntity=null;
        try {

            challengesByLang = challengeService.getChallengesByLangandTopic(programmingLang,topic);

            responseEntity = new ResponseEntity<List<Challenge>>(challengesByLang, HttpStatus.OK);
        }
        catch (LangNotFoundException ex){
            System.out.println(exceptionMessage+" and trace is "+ex);
        }
        catch (TopicNotFoundException ex){
            responseEntity = new ResponseEntity<String>(exceptionMessage, HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    //Before adding Search

    @GetMapping()
    public ResponseEntity<?> getAllChallenges(){

        ResponseEntity responseEntity;
        List<ChallengeObjL1> challengesList = challengeService.getAllChallenges();
        responseEntity = new ResponseEntity<List<ChallengeObjL1>>(challengesList,HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping(value = "/basic")
    public ResponseEntity<?> getAllChallengesBasic(){

        ResponseEntity responseEntity;
        List<Challenge> challengesList = challengeService.getAllChallengesBasic();
        responseEntity = new ResponseEntity<List<Challenge>>(challengesList,HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> getChallengesBySearch(@RequestParam(value = "PL") String programmingLang, @RequestParam(value = "Topic") String topic,@RequestParam(value = "Lvl") Double level) throws ChallengeNotFoundException {

        ResponseEntity responseEntity;
        Map<String, ChallengeObjL4> challengesList = challengeService.getChallangesBySearch(programmingLang,topic,level);
        responseEntity =new ResponseEntity(challengesList,HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getChallengeById(@PathVariable(value = "id") String challengeId){

        ResponseEntity responseEntity;
        try {
            Optional<Challenge> savedChallenge = challengeService.getChallengeById(challengeId);
            responseEntity = new ResponseEntity<Challenge>(savedChallenge.get(),HttpStatus.OK);
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

    @PutMapping()
    public ResponseEntity<?> updateChallenge(Challenge challenge){

        ResponseEntity responseEntity;
        try {
            challengeService.updateChallenge(challenge);
            responseEntity = new ResponseEntity(challengeService.getChallengeById(challenge.getChallengeId()),HttpStatus.OK);
        }
        catch (ChallengeNotFoundException e) {
            responseEntity = new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
        }
        catch (ChallengeAlreadyExistsException e) {
            responseEntity = new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteChallengeByID(@PathVariable(value = "id") String challengeId){

        ResponseEntity responseEntity;
        try {
            List<Challenge> savedChallenge = challengeService.deleteChallengeById(challengeId);
            responseEntity = new ResponseEntity(savedChallenge,HttpStatus.OK);
        }
        catch (ChallengeNotFoundException ex){
            responseEntity = new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
}