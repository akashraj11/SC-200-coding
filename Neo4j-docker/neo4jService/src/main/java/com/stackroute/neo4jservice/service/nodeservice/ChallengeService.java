package com.stackroute.neo4jservice.service.nodeservice;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import org.springframework.stereotype.Service;


import java.util.List;

public interface ChallengeService {
    public Challenge saveChallenge(Challenge challenge);
    public String deleteChallenge(String id);
    public List<Challenge> getAllChallenge();
    //public List<Challenge> getSameLevelChallenge();
}
