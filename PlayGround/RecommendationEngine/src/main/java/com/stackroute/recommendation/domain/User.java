package com.stackroute.recommendation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
    public class User{

        @Id
        private String id;



    @Property
        private String name;
        @Property
        private String preferredLang;

        public User(String id,String name, String preferredLang) {
            this.id=id;
            this.name = name;
            this.preferredLang = preferredLang;
        }

        public User() {

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

    public String getPreferredLang() {
        return preferredLang;
    }

    public void setPreferredLang(String preferredLang) {
        this.preferredLang = preferredLang;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", preferredLang='" + preferredLang + '\'' +
                '}';
    }
}
