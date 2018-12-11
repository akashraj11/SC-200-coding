package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Challenge;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends Neo4jRepository<Challenge,String> {
    @Query ("Match (challenge:Challenge)-[r:isAttemptedBy]->(u:User) where u.name={name} and r.status='solved'" +
            "return challenge")
    ///and status is solved
    List<Challenge> getAttemptedSolvedChallenges(@Param("name") String name);
    @Query ("Match(u:User),(challenge:Challenge) where (u.name={name}) and challenge.level=1 and" +
            "(not (challenge)-[:isAttemptedBy]->(u)) and (not (challenge)-[:isPostedBy]->(u))" +
            "return challenge")
    //Get me the basic level challenges which is neither attempted by the same user nor posted by him
    List<Challenge> getBasicUnattemptedChallenges(@Param("name") String name);
    ///Get me the basic level challenges which are attempted by the user and unsolved
    @Query ("Match (challenge:Challenge)-[r:isAttemptedBy]->(u:User) where u.name={name} and r.status='Unsolved'" +
            "return challenge")
    List<Challenge>  getBasicUnsolvedChallenge(@Param("name") String name);

    @Query ("Match(u:User),(challenge:Challenge) where (u.name={name}) and challenge.level=2 and"+
            "(not (challenge)-[:isAttemptedBy]->(u)) and (not (challenge)-[:isPostedBy]->(u))"+
            "return challenge")
    //Get me the Intermediate challenges based query which is not attempted by the same user or attempted but status unsolved
    List<Challenge> getIntermediateUnattemptedChallenges(@Param("name") String name);

    ///Get me the intermediate level challenges which are attempted by the user and unsolved
    @Query ("Match (challenge:Challenge)-[r:isAttemptedBy]->(u:User) where u.name={name} and r.status='Unsolved'" +
            "return challenge")
    List<Challenge>  getIntermediateUnsolvedChallenge(@Param("name") String name);
    @Query ("Match(u:User),(challenge:Challenge) where (u.name={name}) and challenge.level=3 and"+
            "(not (challenge)-[:isAttemptedBy]->(u)) and (not (challenge)-[:isPostedBy]->(u))"+
            "return challenge")
    //Get me the Advanced challenges based query which is not attempted by the same user or attempted but status unsolved
    List<Challenge> getAdvancedUnattemptedChallenges(@Param("name") String name);

    ///Get me the advanced level challenges which are attempted by the user and unsolved
    @Query ("Match (challenge:Challenge)-[r:isAttemptedBy]->(u:User) where u.name={name} and r.status='Unsolved'" +
            "return challenge")
    List<Challenge>  getAdvancedUnsolvedChallenge(@Param("name") String name);



}
