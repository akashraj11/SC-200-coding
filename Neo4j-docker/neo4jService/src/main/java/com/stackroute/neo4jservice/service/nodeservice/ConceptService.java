package com.stackroute.neo4jservice.service.nodeservice;

import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.exception.ConceptNotFoundException;

import java.util.List;

public interface ConceptService {
    public Concept saveConcept(Concept concept);
    public String deleteConcept(String id);
    public List<Concept> getAllConcepts();
    public Concept searchConceptByName(String name);
            //throws ConceptNotFoundException;

}
