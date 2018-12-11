package com.stackroute.neo4jservice.domain.relation;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.User;

import org.neo4j.ogm.annotation.*;

import java.util.Date;
import java.util.List;

@RelationshipEntity(type="isAttemptedBy")
public class Attempt {

    @Id

    //@GeneratedValue
    @Property
    private int id;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Property
    private Date date;




    //    @Property
//    private String name;
    @Property
    private String status;
    @Property
    private double score;


    public Challenge getChallenge() {
        return challenge;
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

    @StartNode
    Challenge challenge;

    @EndNode
    User user;

    public Attempt() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Attempt{" +
                "id=" + id +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", score=" + score +
                ", challenge=" + challenge +
                ", user=" + user +
                '}';
    }
}
