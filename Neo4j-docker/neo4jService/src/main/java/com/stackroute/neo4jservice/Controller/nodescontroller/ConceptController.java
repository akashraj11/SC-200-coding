package com.stackroute.neo4jservice.Controller.nodescontroller;


import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.Concept;

import com.stackroute.neo4jservice.service.nodeservice.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ConceptController {
    private ConceptService conceptService;

    @Autowired
    public ConceptController(ConceptService conceptService) {
        this.conceptService = conceptService;
    }

    @PostMapping("concept")
    public ResponseEntity<?> saveChallenge(@RequestBody Concept concept) {
        ResponseEntity responseEntity;
        Concept savedConcept = conceptService.saveConcept(concept);
        responseEntity = new ResponseEntity<Concept>(savedConcept, HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("concept")
    public ResponseEntity<?> getAllConcepts()
    {
        List<Concept> conceptList;
        conceptList=conceptService.getAllConcepts();
        ResponseEntity responseEntity=new ResponseEntity<List<Concept>>(conceptList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("concept/{id}")
    public ResponseEntity<?> deleteConcept(@PathVariable("id") String id) {
        List<Challenge> conceptList;
        ResponseEntity responseEntity;
        String message = conceptService.deleteConcept(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
