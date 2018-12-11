package com.sc200.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomFileContent {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }
}
