package com.stackroute.neo4jservice.domain.nodes;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.oracle.webservices.internal.api.message.PropertySet;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Challenge {


    @Id
    private String challengeId;
    @Property
    private String title;
    @Property
    private double level;
    @Property
    private String challengeStamp;
    @Property
    private String challengeTitle;
    @Property
    private String topic;
    @Property
    private String userId;


    public String getChallengeTitle() {
        return challengeTitle;
    }

    public void setChallengeTitle(String challengeTitle) {
        this.challengeTitle = challengeTitle;
    }
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
       //
        this.topic=topic;
    }

    @JsonIgnore
    @Relationship(type="isTypeOf")
    Concept concept;
    public Challenge() {

    }

    public Challenge(String challengeId, String challengeTitle, double level, String challengeStamp ,String topic,String userId) {
        this.challengeId = challengeId;
        this.challengeTitle=challengeTitle;
        this.level = level;
        this.challengeStamp = challengeStamp;
        this.topic=topic;
        this.userId=userId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(String challengeId) {
        this.challengeId = challengeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setChallengeStamp(String challengeStamp){
        this.challengeStamp=challengeStamp;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getchallengeStamp() {
        return challengeStamp;
    }

    public void setSmallDescription(String smallDescription) {
        this.challengeStamp = smallDescription;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "challengeId='" + challengeId + '\'' +
                ",topic='" + topic +'\''+
                ", challengeTitle='" + challengeTitle + '\'' +
                ", Title='" + title + '\'' +

                ", level=" + level +
                ", userId=" + userId +

                ", challengeStamp='" + challengeStamp + '\'' +
                '}';
    }
}

