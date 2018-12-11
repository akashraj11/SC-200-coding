package com.sc200.service;

import com.sc200.domain.File;

import java.io.IOException;

public interface FileService {

    public String parseFile(File file) throws IOException;

    public boolean createDirectories(String path);

    public boolean createFile(File  file) throws IOException;

    public String createTree();

    public  String replaceLast(String string, String toReplace, String replacement);
}
