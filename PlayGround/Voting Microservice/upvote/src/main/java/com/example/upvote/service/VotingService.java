package com.example.upvote.service;

import com.example.upvote.domain.Voting;

import java.util.List;

public interface VotingService {


    Voting updateVotingById(int id,Voting voting);
    List<Voting> getAllVotings();
    Voting saveVoting(Voting voting);
    Voting searchVotingById(int id);





}
