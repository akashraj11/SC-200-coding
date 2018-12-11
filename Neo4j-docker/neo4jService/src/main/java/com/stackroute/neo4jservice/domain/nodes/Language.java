package com.stackroute.neo4jservice.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Language {

    @Property
    @Id
    private String id;
    @Property
    private String name;
    @JsonIgnore
    @Relationship(type = "isA")
    Source source;

    public Language() {
    }

    public Language(String id, String name) {
        this.id = id;
        this.name = name;
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
        return "Language{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", source=" + source +
                '}';
    }
//
//    private List<Language> Languagelist;
//
//    public List<Language> getLanguagelist() {
//        return Languagelist;


}
