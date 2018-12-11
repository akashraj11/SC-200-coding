package com.sc200.service;

import com.sc200.domain.File;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Service
public class CompileServiceImpl implements CompileService {


    FileParserService fileParserService;

    public CompileServiceImpl(FileParserService fileParserService){this.fileParserService = fileParserService;}


    @Override
    public ArrayList<String> runFile(File file) throws IOException {

        ArrayList<String> lines = new ArrayList<String>();
        int i=0;

        try{
            String relativePath =  this.fileParserService.findRelativePath(file);
            String fileName =  this.fileParserService.findFileName(file);
            String[] command = {"/bin/bash", "dockerize.sh" , relativePath , fileName  , "" + (int)fileName.charAt(0) + ""};
            ProcessBuilder p = new ProcessBuilder(command);
    	    Process p2 = p.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
                lines.add(line);
                i++;
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return lines;
    }
    @Override
    public void clone(String url) throws IOException{
        try{
            String[] strings = url.split("$");
            String[] command = { "/bin/bash","clonescript.sh",strings[0],strings[1],strings[2]};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
	    System.out.println("cloned the repository");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
