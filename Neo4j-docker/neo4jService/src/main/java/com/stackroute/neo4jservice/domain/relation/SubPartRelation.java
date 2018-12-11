package com.stackroute.neo4jservice.domain.relation;

import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.nodes.Language;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type="isSubPartOf")
public class SubPartRelation {

    @Id
    private String id;
    @Property
    private String name;

    @StartNode
    Concept concept1;

    @EndNode
    Concept concept2;

    public SubPartRelation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Concept getConcept1() {
        return concept1;
    }

    public void setConcept1(Concept concept1) {
        this.concept1 = concept1;
    }

    public Concept getConcept2() {
        return concept2;
    }

    public void setConcept2(Concept concept2) {
        this.concept2 = concept2;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
