package com.stackroute.neo4jservice.domain.relation;

import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.domain.nodes.Source;
import org.neo4j.ogm.annotation.*;

import javax.validation.constraints.NotNull;

@RelationshipEntity(type="isA")
public class IsARelation {
    @Id
    private String id;
    @Property
    private String name;
    @StartNode
    private Language language;
    @EndNode
    private Source source;


    public IsARelation() {
    }

    public IsARelation(String id, String name, Source source, Language language) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.language = language;
    }

    @Override
    public String toString() {
        return "IsARelation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", source=" + source +
                ", language=" + language +
                '}';
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
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


}
