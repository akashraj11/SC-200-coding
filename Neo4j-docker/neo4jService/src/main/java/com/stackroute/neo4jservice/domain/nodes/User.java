package com.stackroute.neo4jservice.domain.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity
public class User{

    @Id
    private String userId;

    @Property
    private String name;
    @Property
    private String preferredLang;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String userId, String name, String preferredLang) {
        this.userId=userId;
        this.name = name;
        this.preferredLang = preferredLang;
    }
    @JsonIgnore
    @Relationship(type="isPostedBy")
    Challenge challenge;
    @JsonIgnore
    @Relationship(type="isAttemptedBy")
    Challenge challengeA;

    public User() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", preferredLang='" + preferredLang + '\'' +
                ", challengeA=" + challengeA +
                '}';
    }
}
