package com.stackroute.neo4jservice.domain.relation;

import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.domain.nodes.Source;
import org.neo4j.ogm.annotation.*;

import java.util.List;

@RelationshipEntity(type = "isPartOf")
public class PartOfRelation{
    @Id
    private String id;
    @Property
    private String name;

    @StartNode
    Concept concept;

    @EndNode
    Language language;

    public PartOfRelation() {
    }
    public Language getLanguage() {
        return language;
    }


//    public List<Concept> getConcept() {
//        return concept;
//    }

//    public void setConcept(List<Concept> concept) {
//        this.concept = concept;
//    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PartOfRelation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", language=" + language +
                ", concept=" + concept +
                '}';
    }

}