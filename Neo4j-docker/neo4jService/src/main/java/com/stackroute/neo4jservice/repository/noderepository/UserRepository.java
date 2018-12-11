package com.stackroute.neo4jservice.repository.noderepository;


import com.stackroute.neo4jservice.domain.nodes.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.GraphRepositoryQuery;

public interface UserRepository extends Neo4jRepository<User,String> {
}
