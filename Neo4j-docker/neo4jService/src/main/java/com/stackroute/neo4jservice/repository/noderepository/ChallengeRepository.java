package com.stackroute.neo4jservice.repository.noderepository;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ChallengeRepository extends Neo4jRepository<Challenge,String> {
}
