package com.stackroute.challengecreator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeObjL4 {

    @Id
    private String id ;

    private String userId;

    private String challengeTitle;

    private String challengeStamp;

    private String challengeStatement;

    private String solutionUrl;

    private String boilerPlateUrl;

    private String inputFormat;

    private String outputFormat;

    private String programmingLang;

    private String constraints;

    private String topic;

    private double level;

    private double maxScore;

    private double maxRuntime;

    private double rating;
}
