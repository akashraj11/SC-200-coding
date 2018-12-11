package com.stackroute.neo4jservice.Controller.nodescontroller;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.service.nodeservice.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class LanguageController {


    private LanguageService languageService;


    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("language")
    public ResponseEntity<?> saveLanguage(@RequestBody Language language) {
        ResponseEntity responseEntity;
        Language savedLanguage = languageService.saveLanguage(language);
        responseEntity = new ResponseEntity<Language>(savedLanguage, HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("language")
    public ResponseEntity<?> getAllLanguages()
    {
        List<Language> languageList;
        languageList=languageService.getAllLanguage();
        ResponseEntity responseEntity=new ResponseEntity<List<Language>>(languageList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("language/{id}")
    public ResponseEntity<?> deleteLanguage(@PathVariable("id") String id) {
        List<Language> languageList;
        ResponseEntity responseEntity;
        String message = languageService.deleteLanguage(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
