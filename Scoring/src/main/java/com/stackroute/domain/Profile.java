package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
    private String challengeId;
    private String challengeTitle;
    private String userId;
    private double challengeScore;
    private double maxScore;
    private String status;
}
