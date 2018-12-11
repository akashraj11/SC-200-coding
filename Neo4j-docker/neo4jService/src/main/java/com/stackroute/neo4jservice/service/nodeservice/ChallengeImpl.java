package com.stackroute.neo4jservice.service.nodeservice;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.repository.noderepository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeImpl implements ChallengeService {
    ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeImpl(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }
    @Override
    public Challenge saveChallenge(Challenge challenge) {
        Challenge savedChallenge = challengeRepository.save(challenge);
        return savedChallenge;
    }

    @Override
    public String deleteChallenge(String id) {
        challengeRepository.deleteById(id);
        return ("Successfully deleted");
    }

    @Override
    public List<Challenge> getAllChallenge() {
        return  (List<Challenge>)challengeRepository.findAll();
    }

//    @Override
//    public List<Challenge> getSameLevelChallenge() {
//
//        return null;
//    }
}
