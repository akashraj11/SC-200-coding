package com.sc200.domain;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Builder

public class Directory {

    private ArrayList<String> paths;

    private ArrayList<String> contents;

    public ArrayList<String> getContents() {
        return contents;
    }

    public ArrayList<String> getPaths() {
        return paths;
    }

}
