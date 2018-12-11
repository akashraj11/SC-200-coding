package com.stackroute.neo4jservice.Controller.relationcontroller;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.relation.Post;
import com.stackroute.neo4jservice.domain.relation.SubPartRelation;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.PostService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.SubPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SubPartController {
    private SubPartService subPartService;

    @Autowired
    public SubPartController(SubPartService subPartService) {
        this.subPartService = subPartService;
    }

    @PostMapping("subpart")
    public ResponseEntity<?> saveSubPartRelation(@RequestBody SubPartRelation subPartRelation) {
        ResponseEntity responseEntity;
        SubPartRelation savedSubPartRelation = subPartService.saveSubPartRelation(subPartRelation);
        responseEntity = new ResponseEntity<SubPartRelation>(savedSubPartRelation, HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("subpart")
    public ResponseEntity<?> getAllSubpartRelation()
    {
        List<SubPartRelation> subPartRelationList;
        subPartRelationList=subPartService.getAllSubPartRelation();
        ResponseEntity responseEntity=new ResponseEntity<List<SubPartRelation>>(subPartRelationList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("subpart/{id}")
    public ResponseEntity<?> deleteSubPart(@PathVariable("id") String id) {
        List<SubPartRelation> subPartRelationList;
        ResponseEntity responseEntity;
        String message = subPartService.deleteSubPart(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
