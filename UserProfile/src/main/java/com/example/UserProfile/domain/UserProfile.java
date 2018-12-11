package com.example.UserProfile.domain;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.UserProfile.domain.Challenge;

import java.util.Arrays;
import java.util.List;

@Document(collection="userProfile1")

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Builder

public class UserProfile {








    @Id
    private String email;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String dateOfBirth;
    private long phone;
    private double score;
    private int ranking;
    private String preferredLang;
    private List<Challenge> challengeAttempted;
    private List<Challenge> challengeCreated;
    private List<Challenge> challengeUpvoted;
    private List<Challenge> challengeDownvoted;



}
