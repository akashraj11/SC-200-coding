package com.stackroute.challengecreator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {

    @Id
    private String challengeId ;

    private String userId;

    @NotNull
    private String challengeTitle;

    @NotNull
    private String challengeStamp;

    @NotNull
    private String challengeStatement;

    @NotNull
    private String solutionUrl;

    @NotNull
    private String boilerPlateUrl;

    @NotNull
    private String programmingLang;

    @NotNull
    private String constraints;

    @NotNull
    private String topic;

    private String inputFormat;
    private String outputFormat;

    @NotNull
    private double maxScore;

    @NotNull
    private double maxRuntime;

    @NotNull
    private double level;

    @NotNull
    private double rating;

    private double upvotes;
    private double downvotes;

}
