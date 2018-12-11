package com.stackroute.challengecreator.repository;

import com.stackroute.challengecreator.domain.ChallengeObjL1;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChallengeRepositoryL1 extends MongoRepository<ChallengeObjL1,String> {
}
