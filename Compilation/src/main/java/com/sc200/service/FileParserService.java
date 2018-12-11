package com.sc200.service;

import com.sc200.domain.File;

import java.io.IOException;

public interface FileParserService {

    public String findRelativePath(File  file) throws IOException;

    public String findFileName(File  file) throws IOException;

}
