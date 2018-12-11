package com.stackroute.neo4jservice.Controller.relationcontroller;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.relation.PartOfRelation;

import com.stackroute.neo4jservice.service.relationservice.serviceinterface.PartOfRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PartOfController {
    private PartOfRelationService partOfRelationService;

    @Autowired
    public PartOfController(PartOfRelationService partOfRelationService){
        this.partOfRelationService =partOfRelationService;
    }

    @PostMapping("partOf")
    public ResponseEntity<?> savePartOfRelation(@RequestBody PartOfRelation partOfRelation) {
        ResponseEntity responseEntity;
        PartOfRelation savedPartOfRelation = partOfRelationService.savePartOfRelation(partOfRelation);
        responseEntity = new ResponseEntity<PartOfRelation>(savedPartOfRelation, HttpStatus.CREATED);

        return responseEntity;
    }
//    @GetMapping("partOf")
//    public ResponseEntity<?> getAllPartOfRelation()
//    {
//        PartOfRelation partOfRelation1;
//        partOfRelation1=partOfRelationService.getAllPartOfRelation();
//        ResponseEntity responseEntity=new ResponseEntity(partOfRelation1,HttpStatus.OK);
//        return responseEntity;
//    }
    @GetMapping("partOf")
    public ResponseEntity<?> getAllPartOfRelation()
    {
        List<PartOfRelation> partOfRelationList;
        partOfRelationList=partOfRelationService.getAllPartOfRelation();
        ResponseEntity responseEntity=new ResponseEntity<List<PartOfRelation>>(partOfRelationList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("partOf/{id}")
    public ResponseEntity<?> deletePartOfRelation(@PathVariable("id") String id) {
        List<PartOfRelation> partOfRelationList;
        ResponseEntity responseEntity;
        String message = partOfRelationService.deletePartOfRelation(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
