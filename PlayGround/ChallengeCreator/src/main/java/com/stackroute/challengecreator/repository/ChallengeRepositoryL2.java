package com.stackroute.challengecreator.repository;

import com.stackroute.challengecreator.domain.ChallengeObjL2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChallengeRepositoryL2 extends MongoRepository<ChallengeObjL2,String> {
}
