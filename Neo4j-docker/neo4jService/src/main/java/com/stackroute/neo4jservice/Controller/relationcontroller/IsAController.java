package com.stackroute.neo4jservice.Controller.relationcontroller;


import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.relation.IsARelation;

import com.stackroute.neo4jservice.service.relationservice.serviceinterface.IsARelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class IsAController {
    private IsARelationService isARelationService;

    @Autowired
    public IsAController(IsARelationService isARelationService) {
        this.isARelationService =isARelationService;
    }

    @PostMapping("is_a")
    public ResponseEntity<?> saveIsARelation(@RequestBody IsARelation isARelation) {
        //System.out.println("incoming data is ---------------------------------> "+isARelation);
        ResponseEntity responseEntity;
        IsARelation savedIsARelation = isARelationService.saveIsARelation(isARelation);
        responseEntity = new ResponseEntity<IsARelation>(savedIsARelation, HttpStatus.CREATED);

        return responseEntity;
//        return new ResponseEntity<String>("true", HttpStatus.CREATED);
    }
    @GetMapping("is_a")
    public ResponseEntity<?> getAllIsARelation()
    {
        List<IsARelation> isARelationList;
        isARelationList=isARelationService.getAllIsARelation();
        ResponseEntity responseEntity=new ResponseEntity<List<IsARelation>>(isARelationList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("is_a/{id}")
    public ResponseEntity<?> deleteIsARelation(@PathVariable("id") String id) {
        List<IsARelation> isARelationList;
        ResponseEntity responseEntity;
        String message = isARelationService.deleteIsARelation(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
