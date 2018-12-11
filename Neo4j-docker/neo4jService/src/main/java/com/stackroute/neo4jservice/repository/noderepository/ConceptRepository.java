package com.stackroute.neo4jservice.repository.noderepository;

import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.exception.ConceptNotFoundException;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ConceptRepository extends Neo4jRepository<Concept,String> {
//    @Query("LOAD CSV WITH HEADERS FROM "file:///home/cgi/Documents/javaConcepts1.csv" AS row
//    CREATE(n:Concept{nodeid:row.node_id,name:row.name,parentnodeid:row.parent_node_id})")

    //[:ACTED_IN|:DIRECTED]-

    public Concept findByName(String conceptName);
//    @Query ("Match (concept:Concept)-[r:isPartOf|r:isSubPartOf]-> (lang:Language) RETURN concept)")
//    List<Concept> getAllConcepts();
}
