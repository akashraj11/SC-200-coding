package com.stackroute.neo4jservice.repository.relationrepository;

import com.stackroute.neo4jservice.domain.relation.SubPartRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SubPartRepository extends Neo4jRepository<SubPartRelation,String> {
}
