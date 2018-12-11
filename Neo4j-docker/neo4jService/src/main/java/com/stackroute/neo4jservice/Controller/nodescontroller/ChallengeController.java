package com.stackroute.neo4jservice.Controller.nodescontroller;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.service.nodeservice.ChallengeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ChallengeController {

    private ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping("challenge")
    public ResponseEntity<?> saveChallenge(@RequestBody Challenge challenge) {
        ResponseEntity responseEntity;
        Challenge savedChallenge = challengeService.saveChallenge(challenge);
        responseEntity = new ResponseEntity<Challenge>(savedChallenge, HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("challenge")
    public ResponseEntity<?> getAllChallenge()
    {
        List<Challenge> challengeList;
        challengeList=challengeService.getAllChallenge();
        ResponseEntity responseEntity=new ResponseEntity<List<Challenge>>(challengeList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("challenge/{id}")
    public ResponseEntity<?> deleteChallenge(@PathVariable("id") String id) {
       List<Challenge> challengeList;
       ResponseEntity responseEntity;
       String message = challengeService.deleteChallenge(id);
       responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
