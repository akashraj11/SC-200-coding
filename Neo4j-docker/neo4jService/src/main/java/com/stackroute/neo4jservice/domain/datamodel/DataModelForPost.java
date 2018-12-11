package com.stackroute.neo4jservice.domain.datamodel;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.domain.nodes.User;
import org.neo4j.ogm.annotation.*;

public class DataModelForPost {
    @Id
    //@GeneratedValue
    private int id;
//    @Property
//    private String name;
//    @JsonIgnore
    @Property
    private String languageName;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    //    @JsonIgnore
    @Property
    private String conceptName;

    private String programmingLang;
    private String topic;

    public String getProgrammingLang() {
        return programmingLang;
    }

    public void setProgrammingLang(String programmingLang) {
        this.programmingLang = programmingLang;
    }

    @StartNode
    Challenge challenge;
    @EndNode
    User user;

    public DataModelForPost() {
    }

    public DataModelForPost(int id, String languageName, String conceptName,Challenge challenge, User user) {
        this.id = id;
        this.languageName = languageName;
        this.conceptName = conceptName;
       // this.level = level;
        this.challenge = challenge;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }



//    public double getLevel() {
//        return level;
//    }
//
//    public void setLevel(double level) {
//        this.level = level;
//    }

    public Challenge getChallenge() {
        return challenge;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DataModelForPost{" +
                "id='" + id + '\'' +
                ", languageName=" + languageName +
                ", conceptName=" + conceptName +
//                ", level=" + level +
                ", challenge=" + challenge +
                ", user=" + user +
                '}';
    }
}
