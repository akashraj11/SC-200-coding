package com.sc200.domain;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Request {

    private String userId;

    private String challengeId;

    private ArrayList<String> textFile;

    private ArrayList<String> fileContent;

    private ArrayList<String> filepaths;

    public String getUserId() {
        return userId;
    }

    public String getChallengeId() {
        return challengeId;
    }

    public ArrayList<String> getTextFile() {
        return textFile;
    }

    public ArrayList<String> getFileContent() {
        return fileContent;
    }

    public ArrayList<String> getFilepaths() {
        return filepaths;
    }
    
}
