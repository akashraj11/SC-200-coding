package com.example.upvote.controller;

import com.example.upvote.domain.Voting;
import com.example.upvote.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/sc200/voting")
 @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//  @CrossOrigin
public class VotingController {


    private VotingService votingService;

    @Autowired
    public VotingController( VotingService votingService) {
            this.votingService = votingService;

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateVotingById(@Valid @RequestBody Voting voting , @PathVariable("id") int id){
        ResponseEntity responseEntity;

          votingService.updateVotingById(id,voting);
        responseEntity = new ResponseEntity<Voting>(voting, HttpStatus.CREATED);

        return responseEntity;
    }
    @PostMapping("posting")
    public ResponseEntity<?> saveVoting(@Valid @RequestBody Voting voting){
        ResponseEntity responseEntity;

            votingService.saveVoting(voting);
            responseEntity= new ResponseEntity<Voting>(voting, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping (value = "gettingall")
    public ResponseEntity<?> getAllVotings(){
        return new ResponseEntity<List<Voting>>(votingService.getAllVotings(),HttpStatus.OK);
    }
    @GetMapping(path = "/getting/{id}")
    public ResponseEntity<?> searchById(@PathVariable("id") int id){
//       ResponseEntity responseEntity;
//        try{
//            Voting voting= votingService.searchVotingById(id);
//            responseEntity= new ResponseEntity<Voting>(voting,HttpStatus.FOUND);
//        }catch (Exception e){
//
//            responseEntity= new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);
//            System.out.println(id+" id not found");
//        }
//        return responseEntity;
        return new ResponseEntity<Voting>(votingService.searchVotingById(id),HttpStatus.OK);
    }

}