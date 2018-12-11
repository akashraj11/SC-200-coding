package com.stackroute.neo4jservice.Controller.relationcontroller;


import com.stackroute.neo4jservice.domain.relation.TypeRelation;

import com.stackroute.neo4jservice.service.relationservice.serviceinterface.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping("type")
    public ResponseEntity<?> saveTypeRelation(@RequestBody TypeRelation typeRelation) {
        ResponseEntity responseEntity;
        TypeRelation savedTypeRelation = typeService.saveTypeRelation(typeRelation);
        responseEntity = new ResponseEntity<TypeRelation>(savedTypeRelation, HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("type")
    public ResponseEntity<?> getAllTypeRelation()
    {
        List<TypeRelation> typeRelationList;
        typeRelationList=typeService.getAllTypeRelation();
        ResponseEntity responseEntity=new ResponseEntity<List<TypeRelation>>(typeRelationList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("type/{id}")
    public ResponseEntity<?> deleteType(@PathVariable("id") String id) {
        List<TypeRelation> typeList;
        ResponseEntity responseEntity;
        String message = typeService.deleteTypeRelation(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
