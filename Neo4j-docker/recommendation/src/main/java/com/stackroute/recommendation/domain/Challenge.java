package com.stackroute.recommendation.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity
    public class Challenge {


    @Property
        @Id
        private String challengeId;
        @Property
        private String challengeTitle;
        @Property
        private double level;
        @Property
        private String challengeStamp;

    public Challenge(String challengeId, String challengeTitle, double level, String challengeStamp) {
        this.challengeId = challengeId;
        this.challengeTitle =challengeTitle ;
        this.level = level;
        this.challengeStamp = challengeStamp;
    }

    public Challenge() {
    }


    public String getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(String challengeId){
        this.challengeId = challengeId;
    }

    public String getChallengeTitle() {
        return challengeTitle;
    }

    public void setChallengeTitle(String challengeTitle) {
        this.challengeTitle= challengeTitle;
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
                "id='" + challengeId + '\'' +
                ", title='" + challengeTitle + '\'' +
                ", level=" + level +
                ", challengeStamp='" + challengeStamp + '\'' +
                '}';
    }
}
