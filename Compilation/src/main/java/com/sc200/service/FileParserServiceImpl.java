package com.sc200.service;

import com.sc200.domain.File;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileParserServiceImpl implements FileParserService {


    @Override
    public String findRelativePath(File  file) throws IOException{

        String[] subStrings = file.path.split("/");
        String relativePath = "";
        for(int i=0 ; i<subStrings.length-2; i++)
        {
            relativePath = relativePath  + subStrings[i] + "/";
        }

        relativePath = relativePath + subStrings[subStrings.length-2];
        return relativePath;

    }

    @Override
    public String findFileName(File  file) throws IOException{

        String[] subStrings = file.path.split("/");

        String fileNameWithExt = "";
        fileNameWithExt = subStrings[subStrings.length-1];
        String[] fileNameSubString = fileNameWithExt.split("\\." );
        String fileName = fileNameSubString[0];
        return fileName;

    }



}
