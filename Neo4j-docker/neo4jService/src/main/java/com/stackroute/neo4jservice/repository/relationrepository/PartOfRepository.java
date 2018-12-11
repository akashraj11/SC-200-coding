package com.stackroute.neo4jservice.repository.relationrepository;

import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.relation.PartOfRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PartOfRepository extends Neo4jRepository<PartOfRelation,String> {
//    @Query("MATCH (Java:Language)<-[r:isPartOf]-(c:Concept) RETURN Java,r,c")
//    List<Concept> getAllConcepts();
//    @Query("MATCH (Java:Language)<-[r:isPartOf]-(c:Concept) WHERE Language.name='Java' RETURN keys(r.id)")
//    List<String> getIdOfRelation();
//    @Query("MATCH (Java:Language)<-[r:isPartOf]-(c:Concept) WHERE Language.name='Java' RETURN keys(r.name)")
//    List<String> getNameOfRelation();
//    @Query("MATCH (Java:Language)<-[r:isPartOf]-(c:Concept) RETURN J")
}
