package com.stackroute.challengecreator.service;

import com.stackroute.challengecreator.domain.*;
import com.stackroute.challengecreator.exceptions.ChallengeAlreadyExistsException;
import com.stackroute.challengecreator.exceptions.ChallengeNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ChallengeService {

    public ChallengeObjL1 addChallengeObjL1(Challenge challenge) throws ChallengeAlreadyExistsException;
    public void addChallengeObjL2(ChallengeObjL2 challengeObjL2);
    public void addChallengeObjL3(ChallengeObjL3 challengeObjL3);
    public void addChallengeObjL4(ChallengeObjL4 challengeObjL4) throws ChallengeAlreadyExistsException;
    public List<ChallengeObjL1> getAllChallenges();
    public Map<String,ChallengeObjL4> getChallangesBySearch(String programmingLang, String topic, Double level) throws ChallengeNotFoundException ;
    public Optional<Challenge> getChallengeById(String id) throws ChallengeNotFoundException;
    public List<Challenge> getChallengeByTitle(String title) throws ChallengeNotFoundException;
    public List<Challenge> getChallengeByRating(double lowerBound,double upperBound) throws ChallengeNotFoundException;
//    public Challenge updateChallenge(int id,Challenge challenge) throws ChallengeNotFoundException;
//    public List<Challenge> deleteChallenge(int id) throws ChallengeNotFoundException;
}
