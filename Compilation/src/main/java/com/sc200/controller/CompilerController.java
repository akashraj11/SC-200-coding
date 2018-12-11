package com.sc200.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sc200.domain.File;
import com.sc200.service.CompileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/compile")
public class CompilerController {

    private SimpMessagingTemplate template;
    private String sessionId;
    private CompileService compileService;

    @Autowired
    public CompilerController(CompileService compileService, SimpMessagingTemplate template) {
        this.compileService = compileService;
        this.template = template;
    }

    //@PostMapping()
    @MessageMapping("/send/message/{sessionId}")
    public void createDirectoryLayer(@Payload @Valid String path, @DestinationVariable("sessionId") String sessionId) throws IOException {
        System.out.println("socket request invoked");
        ResponseEntity responseEntity;
        String response = null;
        path = path.replaceAll("\"" , "");
        File file = new File(path);
        try{
            ArrayList<String> output = compileService.runFile(file);
            for (int i=output.size()-1;i>=0;i--) {
                if(output.get(i).contains("BUILD SUCCESS") || output.get(i).contains("BUILD FAILURE")  ) {
                    response = output.get(i);
                    String res="";
                    if(response.contains("BUILD SUCCESS") ){
                        res = "BUILD SUCCESS";
                    }
                    else if(response.contains("BUILD FAILURE") ){
                        
                        for(int j = i;j<=output.size()-1 ; j++) {
                            if(output.get(j).contains("ERROR") ){
                                res = "BUILD FAILURE\n" + output.get(j); 
                                break;
                            }
                        }
                    }
                    
                    else if(response.contains("Error") ) {
                        
                         for(int j = i;j<=output.size()-1 ; j++) {
                            if(output.get(j).contains("ERROR") ){
                                res = "Error\n" + output.get(j); 
                                break;
                            }
                        }
                        
                    }
                    
                    response = res;
                    break;
                }
            }
            responseEntity = new ResponseEntity<String>(response , HttpStatus.OK);
            this.template.convertAndSend("/results/" + sessionId, responseEntity);
        }
        catch (Exception e){
            ArrayList<String> output = compileService.runFile(file);
            responseEntity = new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
            this.template.convertAndSend("/results/" + sessionId, e.getMessage());
        }
//        return responseEntity;
    }

    @MessageExceptionHandler
    public void handleException(Throwable exception) {
        this.template.convertAndSend("/chat/errors" + this.sessionId, exception.getMessage());
    }


    //adding the git cloning

    @PostMapping("/clone")
    public ResponseEntity<?> createClonedDirectory(@RequestBody @Valid String url) throws IOException{
        ResponseEntity responseEntity;
        try{
            compileService.clone(url);
            responseEntity = new ResponseEntity<String>("created",HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
