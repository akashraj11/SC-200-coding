package com.example.upvote.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Document(collection = "votingtesting3")
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Builder

public class Voting {

    @Id
    public String challengeId;
    public String challengeTitle;
    public int upvotes;
    public int downvotes;
     public  String userId;//
     public boolean flag;
    public  List<String> alreadyVoted = new ArrayList<String>();
//    public Votitrng() {
//    }
//
//    public Voting(int id, int upvotes, int downvotes) {
//        this.id = id;
//        this.upvotes = upvotes;
//        this.downvotes = downvotes;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getUpvotes() {
//        return upvotes;
//    }
//
//    public void setUpvotes(int upvotes) {
//        this.upvotes = upvotes;
//    }
//
//    public int getDownvotes() {
//        return downvotes;
//    }
//
//    public void setDownvotes(int downvotes) {
//        this.downvotes = downvotes;
//    }
//
//    @Override
//    public String toString() {
//        return "Voting{" +
//                "id=" + id +
//                ", upvotes=" + upvotes +
//                ", downvotes=" + downvotes +
//                '}';
//    }
}
