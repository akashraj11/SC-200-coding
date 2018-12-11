package com.stackroute.recommendation.controller;

import com.stackroute.recommendation.domain.Challenge;
import com.stackroute.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/challenge/recommendation")
public class RecommendationController {
    private RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getRecommendedChallenge(@PathVariable String name) {
        ResponseEntity responseEntity;
        List<Challenge> challengeList = recommendationService.getRecommendedChallenges(name);
        responseEntity = new ResponseEntity<List<Challenge>>(challengeList, HttpStatus.OK);
        return responseEntity;
    }
}


            //responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT)







