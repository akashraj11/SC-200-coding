package com.sc200.controller;


import com.sc200.domain.CustomFileContent;
import com.sc200.domain.Directory;
import com.sc200.domain.Files;
import com.sc200.domain.Request;
import com.sc200.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/create")
    public String createDirectoryLayer(@RequestBody @Valid Request request) throws IOException {

            try {
	            	for(int i=0;i<request.getFilepaths().size();i++)
		            {
				System.out.println(" hello " + request.getFilepaths().get(i));
//				System.out.println("content : " + request.getFileContent().get(i));
				int firstIndex = request.getFilepaths().get(i).indexOf("/");
                String directory1 = request.getFilepaths().get(i).substring(firstIndex, request.getFilepaths().get(i).length());
                        System.out.println(directory1);
                String content = "";
                for(int j=0; j<request.getTextFile().size();j++)
                {
                    System.out.println("File path : " + request.getTextFile().get(j));
                    if(request.getFilepaths().get(i).contains(request.getTextFile().get(j)))
                    {
                        content = request.getFileContent().get(j);
                        break;
                    }
                }
                        System.out.println( directory1 + " content is : " + content);
                Files file = new Files("challenges/" + request.getChallengeId() + "/" + request.getUserId()  + directory1 , content , "java");
                                String a = fileService.parseFile(file , request.getChallengeId() , request.getUserId());
		            }
		            return "Succesfully Created";
            }
            catch(Exception e)
            {
                return e.getMessage();
            }

    }

    @PostMapping("/struct")
    public ResponseEntity<?> getDirectoryStructure(@RequestBody @Valid String folderName) throws  IOException{

        ResponseEntity responseEntity;

        try{

            fileService.setPathsAndContent(new File(folderName));
            Directory directory = new Directory(fileService.getPaths(),fileService.getContents());

            ArrayList<String> temp = directory.getContents();
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)==null){
                    temp.remove(i);
                }
            }
            ArrayList<String> temp1 = directory.getPaths();
            for(int i=0;i<temp1.size()-1;i++){
                for(int j=i+1;j<temp1.size();j++){
                    if(temp1.get(i)==temp1.get(j)){
                        temp1.set(j,null);
                    }

                }
            }


            for(int i=0;i<temp1.size();i++){
                if(temp1.get(i)==null){
                    temp1.remove(i);
                }
            }

           Directory directory1 = new Directory(temp1,temp);
            System.out.println(directory1.toString());


            responseEntity = new ResponseEntity<Directory>(directory1 , HttpStatus.OK);
        }
        catch (Exception e){

            //fileService.setPathsAndContent(new File(folderName));
            Directory directory = new Directory(fileService.getPaths(),fileService.getContents());
            responseEntity = new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }

        return  responseEntity;
    }

    @PostMapping("/content")
    public ResponseEntity<?> getFileContent(@RequestBody @Valid String path) throws IOException{
        CustomFileContent content = new CustomFileContent();
        ResponseEntity responseEntity;
        try{
            content.setContent(fileService.customFileReader(path));
             responseEntity = new ResponseEntity<CustomFileContent>(content,HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

}
