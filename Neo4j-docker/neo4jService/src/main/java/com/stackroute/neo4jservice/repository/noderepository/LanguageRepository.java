package com.stackroute.neo4jservice.repository.noderepository;

import com.stackroute.neo4jservice.domain.nodes.Language;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface LanguageRepository extends Neo4jRepository<Language,String> {
//    @Query ("Match (lang:LanguageType)-[r:isA]->(pl:PL) RETURN lang,r,pl)"
//    List<Language> getAllLanguages();
}
