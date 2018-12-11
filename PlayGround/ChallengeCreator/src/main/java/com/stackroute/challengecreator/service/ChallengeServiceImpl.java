package com.stackroute.challengecreator.service;

import com.stackroute.challengecreator.domain.*;
import com.stackroute.challengecreator.exceptions.ChallengeAlreadyExistsException;
import com.stackroute.challengecreator.exceptions.ChallengeNotFoundException;
import com.stackroute.challengecreator.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    private ChallengeRepository challengeRepository;
    private ChallengeRepositoryL1 challengeRepositoryL1;
    private ChallengeRepositoryL2 challengeRepositoryL2;
    private ChallengeRepositoryL3 challengeRepositoryL3;
    private ChallengeRepositoryL4 challengeRepositoryL4;

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeServiceImpl.class);

    public ChallengeServiceImpl(ChallengeRepository challengeRepository,ChallengeRepositoryL1 challengeRepositoryL1,ChallengeRepositoryL2 challengeRepositoryL2,ChallengeRepositoryL3 challengeRepositoryL3,ChallengeRepositoryL4 challengeRepositoryL4) {
        this.challengeRepository = challengeRepository;
        this.challengeRepositoryL1 = challengeRepositoryL1;
        this.challengeRepositoryL2= challengeRepositoryL2;
        this.challengeRepositoryL3 = challengeRepositoryL3;
        this.challengeRepositoryL4 = challengeRepositoryL4;
    }

    @Override
    public ChallengeObjL1 addChallengeObjL1(Challenge challenge) throws ChallengeAlreadyExistsException {

        challengeRepository.save(challenge);

        ChallengeObjL1 challengeObjL1 = new ChallengeObjL1();
        ChallengeObjL2 challengeObjL2 = new ChallengeObjL2();
        ChallengeObjL3 challengeObjL3 = new ChallengeObjL3();
        ChallengeObjL4 challengeObjL4 = new ChallengeObjL4();
        ChallengeObjL1 savedChallenge ;

        String tempLang = challenge.getProgrammingLang();
        String tempTopic = challenge.getTopic();
        Double tempLevel = challenge.getLevel();
        Optional<ChallengeObjL1> tempSavedChallenge = challengeRepositoryL1.findById(tempLang);

        if(!tempSavedChallenge.isPresent())
        {
            challengeObjL4.setId(challenge.getId());
            challengeObjL4.setUserId(challenge.getUserId());
            challengeObjL4.setChallengeTitle(challenge.getChallengeTitle());
            challengeObjL4.setChallengeStamp(challenge.getChallengeStamp());
            challengeObjL4.setChallengeStatement(challenge.getChallengeStatement());
            challengeObjL4.setInputFormat(challenge.getInputFormat());
            challengeObjL4.setOutputFormat(challenge.getOutputFormat());
            challengeObjL4.setBoilerPlateUrl(challenge.getBoilerPlateUrl());
            challengeObjL4.setSolutionUrl(challenge.getSolutionUrl());
            challengeObjL4.setMaxRuntime(challenge.getMaxRuntime());
            challengeObjL4.setMaxScore(challenge.getMaxScore());
            challengeObjL4.setRating(challenge.getRating());
            challengeObjL4.setProgrammingLang(challenge.getProgrammingLang());
            challengeObjL4.setTopic(challenge.getTopic());
            challengeObjL4.setLevel(challenge.getLevel());
            challengeObjL4.setConstraints(challenge.getConstraints());

            addChallengeObjL4(challengeObjL4);

            Map<String,ChallengeObjL4> tempL4 = new HashMap<>();
            tempL4.put(challenge.getChallengeTitle(),challengeObjL4);
            ArrayList<String> tempChallengeTitleList = new ArrayList<>();
            tempChallengeTitleList.add(challenge.getChallengeTitle());

            challengeObjL3.setLevel(challenge.getLevel());
            challengeObjL3.setChallengeTitleList(tempChallengeTitleList);
            challengeObjL3.setChallengesList(tempL4);

            addChallengeObjL3(challengeObjL3);

            Map<Double,ChallengeObjL3> tempL3 = new HashMap<>() ;
            tempL3.put(challenge.getLevel(),challengeObjL3);
            ArrayList<Double> tempLevelsList = new ArrayList<>();
            tempLevelsList.add(challenge.getLevel());

            challengeObjL2.setTopic(challenge.getTopic());
            challengeObjL2.setLevels(tempL3);
            challengeObjL2.setLevelsList(tempLevelsList);

            addChallengeObjL2(challengeObjL2);

            Map<String,ChallengeObjL2> tempL2 = new HashMap<>();
            tempL2.put(challenge.getTopic(),challengeObjL2);
            ArrayList<String> tempTopicsList = new ArrayList<>();
            tempTopicsList.add(challenge.getTopic());

            challengeObjL1.setProgrammingLang(challenge.getProgrammingLang());
            challengeObjL1.setTopics(tempL2);
            challengeObjL1.setTopicsList(tempTopicsList);

            savedChallenge = challengeRepositoryL1.save(challengeObjL1);

            return savedChallenge;

        }
        else{
            if (tempSavedChallenge.get().getTopicsList().contains(tempTopic))
            {

                if(tempSavedChallenge.get().getTopics().get(tempTopic).getLevelsList().contains(tempLevel))
                {
                    if (tempSavedChallenge.get().getTopics().get(tempTopic).getLevels().get(tempLevel).getChallengeTitleList().contains(challenge.getChallengeTitle()))
                    {
                        throw new ChallengeAlreadyExistsException();
                    }
                    else
                    {
                        challengeObjL4.setId(challenge.getId());
                        challengeObjL4.setUserId(challenge.getUserId());
                        challengeObjL4.setChallengeTitle(challenge.getChallengeTitle());
                        challengeObjL4.setChallengeStamp(challenge.getChallengeStamp());
                        challengeObjL4.setChallengeStatement(challenge.getChallengeStatement());
                        challengeObjL4.setInputFormat(challenge.getInputFormat());
                        challengeObjL4.setOutputFormat(challenge.getOutputFormat());
                        challengeObjL4.setBoilerPlateUrl(challenge.getBoilerPlateUrl());
                        challengeObjL4.setSolutionUrl(challenge.getSolutionUrl());
                        challengeObjL4.setMaxRuntime(challenge.getMaxRuntime());
                        challengeObjL4.setMaxScore(challenge.getMaxScore());
                        challengeObjL4.setRating(challenge.getRating());
                        challengeObjL4.setProgrammingLang(challenge.getProgrammingLang());
                        challengeObjL4.setTopic(challenge.getTopic());
                        challengeObjL4.setLevel(challenge.getLevel());
                        challengeObjL4.setConstraints(challenge.getConstraints());

                        addChallengeObjL4(challengeObjL4);

                        tempSavedChallenge.get().getTopics().get(tempTopic).getLevels().get(tempLevel).getChallengeTitleList().add(challenge.getChallengeTitle());
                        tempSavedChallenge.get().getTopics().get(tempTopic).getLevels().get(tempLevel).getChallengesList().put(challenge.getChallengeTitle(),challengeObjL4);

                        challengeRepositoryL1.save(tempSavedChallenge.get());
                    }
                }
                else
                {
                    challengeObjL4.setId(challenge.getId());
                    challengeObjL4.setUserId(challenge.getUserId());
                    challengeObjL4.setChallengeTitle(challenge.getChallengeTitle());
                    challengeObjL4.setChallengeStamp(challenge.getChallengeStamp());
                    challengeObjL4.setChallengeStatement(challenge.getChallengeStatement());
                    challengeObjL4.setInputFormat(challenge.getInputFormat());
                    challengeObjL4.setOutputFormat(challenge.getOutputFormat());
                    challengeObjL4.setBoilerPlateUrl(challenge.getBoilerPlateUrl());
                    challengeObjL4.setSolutionUrl(challenge.getSolutionUrl());
                    challengeObjL4.setMaxRuntime(challenge.getMaxRuntime());
                    challengeObjL4.setMaxScore(challenge.getMaxScore());
                    challengeObjL4.setRating(challenge.getRating());
                    challengeObjL4.setProgrammingLang(challenge.getProgrammingLang());
                    challengeObjL4.setTopic(challenge.getTopic());
                    challengeObjL4.setLevel(challenge.getLevel());
                    challengeObjL4.setConstraints(challenge.getConstraints());

                    addChallengeObjL4(challengeObjL4);

                    Map<String,ChallengeObjL4> tempL4 = new HashMap<>();
                    tempL4.put(challenge.getChallengeTitle(),challengeObjL4);
                    ArrayList<String> tempChallengeTitleList = new ArrayList<>();
                    tempChallengeTitleList.add(challenge.getChallengeTitle());

                    challengeObjL3.setLevel(challenge.getLevel());
                    challengeObjL3.setChallengeTitleList(tempChallengeTitleList);
                    challengeObjL3.setChallengesList(tempL4);

                    addChallengeObjL3(challengeObjL3);

                    tempSavedChallenge.get().getTopics().get(tempTopic).getLevelsList().add(challenge.getLevel());
                    tempSavedChallenge.get().getTopics().get(tempTopic).getLevels().put(challenge.getLevel(),challengeObjL3);

                    challengeRepositoryL1.save(tempSavedChallenge.get());
                }

            }
            else {
                challengeObjL4.setId(challenge.getId());
                challengeObjL4.setUserId(challenge.getUserId());
                challengeObjL4.setChallengeTitle(challenge.getChallengeTitle());
                challengeObjL4.setChallengeStamp(challenge.getChallengeStamp());
                challengeObjL4.setChallengeStatement(challenge.getChallengeStatement());
                challengeObjL4.setInputFormat(challenge.getInputFormat());
                challengeObjL4.setOutputFormat(challenge.getOutputFormat());
                challengeObjL4.setBoilerPlateUrl(challenge.getBoilerPlateUrl());
                challengeObjL4.setSolutionUrl(challenge.getSolutionUrl());
                challengeObjL4.setMaxRuntime(challenge.getMaxRuntime());
                challengeObjL4.setMaxScore(challenge.getMaxScore());
                challengeObjL4.setRating(challenge.getRating());
                challengeObjL4.setProgrammingLang(challenge.getProgrammingLang());
                challengeObjL4.setTopic(challenge.getTopic());
                challengeObjL4.setLevel(challenge.getLevel());
                challengeObjL4.setConstraints(challenge.getConstraints());

                addChallengeObjL4(challengeObjL4);

                Map<String,ChallengeObjL4> tempL4 = new HashMap<>();
                tempL4.put(challenge.getChallengeTitle(),challengeObjL4);
                ArrayList<String> tempChallengeTitleList = new ArrayList<>();
                tempChallengeTitleList.add(challenge.getChallengeTitle());

                challengeObjL3.setLevel(challenge.getLevel());
                challengeObjL3.setChallengeTitleList(tempChallengeTitleList);
                challengeObjL3.setChallengesList(tempL4);

                addChallengeObjL3(challengeObjL3);

                Map<Double,ChallengeObjL3> tempL3 = new HashMap<>() ;
                tempL3.put(challenge.getLevel(),challengeObjL3);
                ArrayList<Double> tempLevelsList = new ArrayList<>();
                tempLevelsList.add(challenge.getLevel());

                challengeObjL2.setTopic(challenge.getTopic());
                challengeObjL2.setLevels(tempL3);
                challengeObjL2.setLevelsList(tempLevelsList);

                addChallengeObjL2(challengeObjL2);

                tempSavedChallenge.get().getTopicsList().add(tempTopic);
                tempSavedChallenge.get().getTopics().put(tempTopic,challengeObjL2);

                challengeRepositoryL1.save(tempSavedChallenge.get());

                return tempSavedChallenge.get();

            }
        }

        return null;
    }

    @Override
    public void addChallengeObjL2(ChallengeObjL2 challengeObjL2) {

        if(!challengeRepositoryL2.existsById(challengeObjL2.getTopic()))
        {
            challengeRepositoryL2.save(challengeObjL2);
        }

    }

    @Override
    public void addChallengeObjL3(ChallengeObjL3 challengeObjL3) {

        if (!challengeRepositoryL3.existsById(challengeObjL3.getLevel())){
            challengeRepositoryL3.save(challengeObjL3);
        }

    }

    @Override
    public void addChallengeObjL4(ChallengeObjL4 challengeObjL4) {

        if (!challengeRepositoryL4.existsById(challengeObjL4.getId())){
            challengeRepositoryL4.save(challengeObjL4);
        }

    }

    @Override
    public List<ChallengeObjL1> getAllChallenges() {
        return  challengeRepositoryL1.findAll();
    }

    @Override
    public Map<String,ChallengeObjL4> getChallangesBySearch(String programmingLang, String topic, Double level) throws ChallengeNotFoundException {

        if(challengeRepositoryL1.findById(programmingLang).isPresent()) {
            return  challengeRepositoryL1.findById(programmingLang).get().getTopics().get(topic).getLevels().get(level).getChallengesList();
        }
        return null;
    }

    @Override
    public Optional<Challenge> getChallengeById(String id) throws ChallengeNotFoundException {
        Optional<Challenge> challenge;
        challenge=challengeRepository.findById(id);
        return challenge;
    }

    @Override
    public List<Challenge> getChallengeByTitle(String title) throws ChallengeNotFoundException {

        List<Challenge> savedChallenge = challengeRepository.getChallengeByTitle(title);
        if(savedChallenge == null){
            LOGGER.warn("challenge-service.challengeNotExistsEx", title);
            throw new ChallengeNotFoundException(title);
        }
        return savedChallenge;
    }

    @Override
    public List<Challenge> getChallengeByRating(double lowerBound, double upperBound) throws ChallengeNotFoundException {

        List<Challenge> challengesList = challengeRepository.getChallengeByRating(lowerBound,upperBound);
        if(challengesList == null){
            throw new ChallengeNotFoundException();
        }
        return challengesList;
    }
//
//    @Override
//    public Challenge updateChallenge(int id, Challenge challenge) throws ChallengeNotFoundException {
//
//        if(!challengeRepository.existsById(id))
//            throw new ChallengeNotFoundException(id);
//        Optional<Challenge> challenge1= getChallengeById(id);
//        if(challenge1.isPresent())
//        {
//            Challenge savedChallenge = challengeRepository.save(challenge);
//            return savedChallenge;
//        }
//        return null;
//    }
//
//
//    @Override
//    public List<Challenge> deleteChallenge(int id) throws ChallengeNotFoundException {
//        if(!challengeRepository.existsById(id))
//            throw new ChallengeNotFoundException(id);
//        Optional<Challenge> challenge1=getChallengeById(id);
//        if(challenge1.isPresent()) {
//            challengeRepository.delete(challenge1.get());
//        }
//        return getAllChallenges();
//    }
}
