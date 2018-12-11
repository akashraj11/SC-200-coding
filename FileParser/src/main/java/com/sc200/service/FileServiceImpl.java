package com.sc200.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

import com.sc200.domain.Files;

@Service
public class FileServiceImpl implements FileService {

    private ArrayList<String> paths = new ArrayList<String>();
    private ArrayList<String> contents = new ArrayList<String>();
    private int i;

    public String parseFile(Files files , String userName , String challengeId) throws IOException {
        System.out.println("file url is "+files.getUri());
        int lastIndex = files.getUri().lastIndexOf("/");
        System.out.println("lastIndex : " +lastIndex);
        String directory = files.getUri().substring(0, lastIndex);
        System.out.println("lenght of the files "+files.getUri().length());
        System.out.println("directory "+directory);
        int firstIndex = files.getUri().indexOf("/");
        System.out.println("firstIndex "+firstIndex);
        String directory1 = files.getUri().substring(0, firstIndex);
        System.out.println("directory 1 :" + directory1);
        if (createDirectories(directory) && createFile(files)) {
            System.out.println("inside createDirecotry ");
            return "Successfully Created";
        }else{
            System.out.println("inside else");
            recursiveDelete(new File(directory1) , userName , challengeId);
                    if (createDirectories(directory) && createFile(files)) {
                return "Successfully Created";
            } else {
                return "Some Error";
            }
        }
    }

        public static void recursiveDelete(File file , String userName , String challengeId) {
            //to end the recursive loop
            System.out.println("inside recusive delete for file :" + file.getPath());
            if (!file.exists()) {
                System.out.println("file does not exist");
                return;
            }
            //if directory, go inside and call recursively
            System.out.println("regex is "+"challenges/" + userName + "/" + challengeId);
            if (file.isDirectory() && file.getPath().contains("challenges/" + userName + "/" + challengeId)) {
                System.out.println("file is directory and we have to delete it "+file.getPath());
                    for (File f : file.listFiles()) {
                        System.out.println("printing all the files inside file.listFiles()"+f.getPath());
                        recursiveDelete(f , userName , challengeId);
                }
                System.out.println("if is directory not deleting" + file.getPath());
                    return;
            }
            else if(file.isDirectory())
            {
                System.out.println("file is directory and we dont have to delete it "+file.getPath());
                for (File f : file.listFiles()) {
                    System.out.println("inside else when deleteing the files");
                    recursiveDelete(f , userName , challengeId);
                }
                return;
            }
            else if((!file.isDirectory()) && file.getPath().contains("challenges/" + userName + "/" + challengeId)) {
                System.out.println("not deleting a file : " + file.getPath() );
                file.delete();
                System.out.println("Deleted file/folder: "+file.getAbsolutePath());

            }
            //call delete to delete files and empty directory
        }



        public boolean createDirectories(String path) {

        //create layers of directories

        File files = new File(path);
        if(!files.exists()) {
            if(files.mkdirs()) {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean createFile(Files file) throws IOException {

        //Create the file
        File newFile = new File(file.getUri());
        if (newFile.createNewFile())
        {
            FileWriter writer = new FileWriter(newFile);
            writer.write(file.getContent());
            writer.close();
            return true;
        } else {
            return false;
        }

    }

//

    public ArrayList<String> getPaths() {
        return this.paths;
    }

    public ArrayList<String> getContents() {
        return this.contents;
    }

    @Override
    public void setPathsAndContent(File dir) {


        String pattern = ".java"; //for example ".java"
        String pattern1 = ".yml";
        String pattern2 = ".properties";
        String pattern3 = ".css";
        String pattern4 = ".html";
        String pattern5 = ".js";
        String pattern6 = ".ts";
        String pattern7 = ".json";
        String pattern8 = ".md";
        String pattern9 = ".txt";

        System.out.println(dir);


        File listFile[] = dir.listFiles();
        System.out.println(listFile[0]);
        System.out.println("check");


        String path[] = new String[listFile.length];
        String content[] = new String[listFile.length];
        if(listFile != null) {
            for(int i=0; i<listFile.length; i++) {
                System.out.println(listFile[i]);
                if (listFile[i] != null) {
                    if (listFile[i].isDirectory()) {
                       // path[i]=listFile[i].getPath();
                        setPathsAndContent(listFile[i]);
                    } else {
                        if (listFile[i].getName().endsWith(pattern) || listFile[i].getName().endsWith(pattern1) || listFile[i].getName().endsWith(pattern2) || listFile[i].getName().endsWith(pattern3) || listFile[i].getName().endsWith(pattern4) || listFile[i].getName().endsWith(pattern5) || listFile[i].getName().endsWith(pattern6) || listFile[i].getName().endsWith(pattern7) || listFile[i].getName().endsWith(pattern8) || listFile[i].getName().endsWith(pattern9)) {
                            try {
                                content[i] = readFile(listFile[i].getPath());
                            } catch (Exception e) {
                                System.out.println("bshfjbdj");
                            }
                            path[i] = listFile[i].getPath();
                        }
                    }
                }
            }

        }
        for(int i=0; i<listFile.length; i++) {

            if(path[i] !="null") {

                paths.add(path[i]);

            }
        }
        for(int i=0; i<listFile.length; i++) {

            if(content[i]!=null){
            contents.add(content[i]);}
        }


    }
    @Override
    public  String customFileReader(String path) throws IOException {
        File f = new File(path);
        String everything = "";
        System.out.println(f + " hello ");
        System.out.println(f.isDirectory());
        BufferedReader br = null;
        if (f.isFile()) {
            try {
                br = new BufferedReader(new FileReader(f));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }

                everything = sb.toString();
                System.out.println(everything);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                br.close();
            }
        }
        return everything;
    }



    public static String readFile(String Path) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            if(stringBuilder.length()>0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            reader.close();
            String content = stringBuilder.toString();
            return content;

        } catch (Exception e) {
            System.out.println("\n\n\n\n" + e.getMessage() +  "\n\n\n\n" );
            return "Error";
        }
    }

}

