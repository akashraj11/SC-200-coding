package com.stackroute.neo4jservice.service.relationservice.serviceinterface;

import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.domain.relation.Attempt;
import com.stackroute.neo4jservice.domain.relation.IsARelation;

import java.util.List;

public interface IsARelationService {
    public IsARelation saveIsARelation(IsARelation isARelation);
    public String deleteIsARelation(String id);
    public List<IsARelation> getAllIsARelation();
}
