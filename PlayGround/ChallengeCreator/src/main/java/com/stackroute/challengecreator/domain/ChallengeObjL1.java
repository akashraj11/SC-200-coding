package com.stackroute.challengecreator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeObjL1 {

    @Id
    private String programmingLang;

    private ArrayList<String> topicsList;

    private Map<String,ChallengeObjL2> topics;

}
