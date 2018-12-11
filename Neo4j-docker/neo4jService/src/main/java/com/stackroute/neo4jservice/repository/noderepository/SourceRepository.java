package com.stackroute.neo4jservice.repository.noderepository;

import com.stackroute.neo4jservice.domain.nodes.Source;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SourceRepository extends Neo4jRepository<Source,String> {
}
