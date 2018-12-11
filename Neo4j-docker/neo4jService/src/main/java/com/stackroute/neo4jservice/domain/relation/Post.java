package com.stackroute.neo4jservice.domain.relation;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.domain.nodes.User;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type="isPostedBy")
public class Post {


    //@GeneratedValue
    @Id
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
//    @Property
//    private double level;
    @StartNode
    Challenge challenge;
    @EndNode
    User user;

    public Post() {
    }

    public Post(int id, Challenge challenge, User user) {
        this.id = id;
        //this.name = name;
        //this.level = level;
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
        return "Post{" +
                "id=" + id +
                ", date=" + date +
                ", challenge=" + challenge +
                ", user=" + user +
                '}';
    }

}
