package com.stackroute.challengecreator.repository;

import com.stackroute.challengecreator.domain.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends MongoRepository<Challenge,String> {
    @Query("{ 'challengeTitle' : ?0 }")
    public List<Challenge> getChallengeByTitle(String title);

    @Query("{ 'rating' : { $gt: ?0, $lt: ?1 } }")
    public List<Challenge> getChallengeByRating(double ratingGT,double ratingLT);
}
