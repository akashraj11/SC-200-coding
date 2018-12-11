package com.stackroute.recommendation.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity
    public class Challenge {


    @Property
        @Id
        private String id;
        @Property
        private String title;
        @Property
        private double level;
        @Property
        private String challengeStamp;

    public Challenge(String id, String title, double level, String challengeStamp) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.challengeStamp = challengeStamp;
    }

    public Challenge() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getChallengeStamp() {
        return challengeStamp;
    }

    public void setChallengeStamp(String challengeStamp) {
        this.challengeStamp = challengeStamp;
    }


    @Override
    public String toString() {
        return "Challenge{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", level=" + level +
                ", challengeStamp='" + challengeStamp + '\'' +
                '}';
    }
}
