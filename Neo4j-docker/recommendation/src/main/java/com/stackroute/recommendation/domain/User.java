package com.stackroute.recommendation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
    public class User{

        @Id
        private String userId;



    @Property
        private String name;
        @Property
        private String preferredLang;

        public User(String userId,String name, String preferredLang) {
            this.userId=userId;
            this.name = name;
            this.preferredLang = preferredLang;
        }

        public User() {

        }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
                "id='" + userId+ '\'' +
                ", name='" + name + '\'' +
                ", preferredLang='" + preferredLang + '\'' +
                '}';
    }
}
