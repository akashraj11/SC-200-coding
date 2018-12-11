package com.stackroute.challengecreator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Map;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeObjL2 {

    @Id
    private String topic;

    private ArrayList<Double> levelsList;

    private Map<Double,ChallengeObjL3> levels;
}
