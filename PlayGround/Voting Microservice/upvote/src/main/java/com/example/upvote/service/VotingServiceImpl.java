package com.example.upvote.service;

import com.example.upvote.domain.Voting;
import com.example.upvote.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingServiceImpl implements VotingService {
    private VotingRepository votingRepository;

    @Autowired
   public VotingServiceImpl(VotingRepository votingRepository){
       this.votingRepository = votingRepository;
    }

    @Override
    public Voting updateVotingById(int id, Voting voting1) {
       Voting voting =votingRepository.findById(id).get();
        voting.setUpvotes(voting1.getUpvotes());
        voting.setDownvotes(voting1.getDownvotes());

        Voting voting2=votingRepository.save(voting);
        return voting2;
    }
    @Override
    public List<Voting> getAllVotings() {
        return votingRepository.findAll();
    }
    @Override
    public Voting saveVoting(Voting voting){

        Voting saveVoting= votingRepository.save(voting);

        return saveVoting;
    }
    @Override
    public Voting searchVotingById(int id) {
        Voting voting= votingRepository.findById(id).get();
        return voting;
    }





}

