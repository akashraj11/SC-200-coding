package com.stackroute.challengecreator.repository;

import com.stackroute.challengecreator.domain.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends MongoRepository<Challenge,String> {

    //Added for Search
    
    @Query("{ 'topic' :{$regex : ?0} }")
    public List<Challenge> getChallengeByTopicReg(@Param("topic") String topic);
    @Query("{ 'topic' : ?0 }")
    public List<Challenge> getChallengeByTopic(@Param("topic") String topic);
    public List<Challenge> getChallengeByProgrammingLang(@Param("programmingLang") String programmingLang);
    @Query("{ 'programmingLang' : ?0, 'topic' : ?1 }")
    public List<Challenge> getChallengeByLangandTopic(@Param("programmingLang") String programmingLang,@Param("topic") String topic);


    @Query("{ 'challengeTitle' : ?0 }")
    public List<Challenge> getChallengeByTitle(String title);

    @Query("{ 'rating' : { $gt: ?0, $lt: ?1 } }")
    public List<Challenge> getChallengeByRating(double ratingGT,double ratingLT);
}
