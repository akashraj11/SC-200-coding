package com.stackroute.challengecreator.service;

import com.stackroute.challengecreator.domain.*;
import com.stackroute.challengecreator.exceptions.ChallengeAlreadyExistsException;
import com.stackroute.challengecreator.exceptions.ChallengeNotFoundException;
import com.stackroute.challengecreator.exceptions.LangNotFoundException;
import com.stackroute.challengecreator.exceptions.TopicNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ChallengeService {

    //Added for Search
    List<Challenge> getChallengesByTopic(String topic) throws TopicNotFoundException;
    List<Challenge> getChallengesByTopicReg(String topic) throws TopicNotFoundException;
    List<Challenge> getChallengesByLang(String programmingLang) throws LangNotFoundException;
    List<Challenge> getChallengesByLangandTopic(String programmingLang,String topic) throws LangNotFoundException,TopicNotFoundException;



    public ChallengeObjL1 addChallengeObjL1(Challenge challenge) throws ChallengeAlreadyExistsException;
    public void addChallengeObjL4(ChallengeObjL4 challengeObjL4) throws ChallengeAlreadyExistsException;

    public List<ChallengeObjL1> getAllChallenges();
    public List<Challenge> getAllChallengesBasic();
    public Map<String,ChallengeObjL4> getChallangesBySearch(String programmingLang, String topic, Double level) throws ChallengeNotFoundException ;
    public Optional<Challenge> getChallengeById(String id) throws ChallengeNotFoundException;
    public List<Challenge> getChallengeByTitle(String title) throws ChallengeNotFoundException;
    public List<Challenge> getChallengeByRating(double lowerBound,double upperBound) throws ChallengeNotFoundException;

    public List<Challenge> deleteChallengeById(String id) throws ChallengeNotFoundException;

    public void updateChallenge(Challenge challenge) throws ChallengeNotFoundException, ChallengeAlreadyExistsException;

}
