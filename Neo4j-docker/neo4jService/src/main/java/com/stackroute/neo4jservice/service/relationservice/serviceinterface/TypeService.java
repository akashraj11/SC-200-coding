package com.stackroute.neo4jservice.service.relationservice.serviceinterface;

import com.stackroute.neo4jservice.domain.relation.Post;
import com.stackroute.neo4jservice.domain.relation.TypeRelation;

import java.util.List;

public interface TypeService {
    public TypeRelation saveTypeRelation(TypeRelation typeRelation);
    public String deleteTypeRelation(String id);
    public List<TypeRelation> getAllTypeRelation();
}
