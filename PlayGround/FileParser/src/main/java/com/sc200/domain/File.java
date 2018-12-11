package com.sc200.domain;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.text.StrBuilder;


@Data
@AllArgsConstructor
@Builder
public class File {

    private String uri;

    private String content;

    private String language;


    public String getUri() {
        return uri;
    }

    public String getLanguage() {
        return language;
    }

    public String getContent() {
        return content;
    }

}
