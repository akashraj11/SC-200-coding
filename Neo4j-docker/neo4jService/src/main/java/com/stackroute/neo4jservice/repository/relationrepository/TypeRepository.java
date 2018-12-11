package com.stackroute.neo4jservice.repository.relationrepository;

import com.stackroute.neo4jservice.domain.relation.TypeRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TypeRepository extends Neo4jRepository<TypeRelation,String> {
}
