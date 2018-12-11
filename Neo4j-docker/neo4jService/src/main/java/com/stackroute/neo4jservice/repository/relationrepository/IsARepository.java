package com.stackroute.neo4jservice.repository.relationrepository;

import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.domain.nodes.Source;
import com.stackroute.neo4jservice.domain.relation.IsARelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface IsARepository extends Neo4jRepository<IsARelation,String> {
//    @Query("MATCH(c:Language)-[r:isA]->(pl:Source) RETURN c,r,pl")
//    List<Language> getAllLanguages();
//    List<IsARelation>getAllLanguages();
}
