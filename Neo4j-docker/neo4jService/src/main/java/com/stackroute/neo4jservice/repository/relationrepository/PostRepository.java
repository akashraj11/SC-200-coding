package com.stackroute.neo4jservice.repository.relationrepository;

import com.stackroute.neo4jservice.domain.relation.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post,Integer> {
}
