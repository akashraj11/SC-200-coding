package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Challenge;

import java.util.List;

public interface RecommendationService {
    public List<Challenge> getRecommendedChallenges(String name);
}
