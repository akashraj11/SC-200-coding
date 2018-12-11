package com.stackroute.neo4jservice.Controller.nodescontroller;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.Source;
import com.stackroute.neo4jservice.service.nodeservice.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SourceController {
    private SourceService sourceService;

    @Autowired
    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @PostMapping("source")
    public ResponseEntity<?> saveSource(@RequestBody Source source) {
        ResponseEntity responseEntity;
        Source savedSource = sourceService.saveSource(source);
        responseEntity = new ResponseEntity<Source>(savedSource, HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("source")
    public ResponseEntity<?> getAllSources()
    {
        List<Source> sourceList;
        sourceList=sourceService.getSource();
        ResponseEntity responseEntity=new ResponseEntity<List<Source>>(sourceList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("source/{id}")
    public ResponseEntity<?> deleteSource(@PathVariable("id") String id) {
        List<Source> sourceList;
        ResponseEntity responseEntity;
        String message = sourceService.deleteSource(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
