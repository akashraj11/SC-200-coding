package com.sc200.service;

import com.sc200.domain.File;

import java.io.IOException;
import java.util.ArrayList;

public interface CompileService {

    public ArrayList<String> runFile(File  file) throws IOException;
    public void clone(String url) throws IOException;
}
