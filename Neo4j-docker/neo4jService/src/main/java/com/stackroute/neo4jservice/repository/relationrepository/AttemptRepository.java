package com.stackroute.neo4jservice.repository.relationrepository;

import com.stackroute.neo4jservice.domain.relation.Attempt;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AttemptRepository extends Neo4jRepository<Attempt,String> {
}
