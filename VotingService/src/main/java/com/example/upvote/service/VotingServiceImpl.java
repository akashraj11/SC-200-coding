package com.example.upvote.service;

import com.example.upvote.Kafka.Producer.VotingResource;
import com.example.upvote.domain.Voting;
import com.example.upvote.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VotingServiceImpl implements VotingService {
    private VotingRepository votingRepository;
    public  List<String> alreadyVoted1 = new ArrayList<String>();
    @Autowired
    VotingResource votingResource;

    @Autowired
    public VotingServiceImpl(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    @Override
    public Voting upvoteVotingById( Voting voting1) {
        if (votingRepository.existsById(voting1.getChallengeId())) {
            Voting voting = votingRepository.findById(voting1.getChallengeId()).get();
            int flag = 0;
            for (int i = 0; i < voting.alreadyVoted.size(); i++) {
                if (voting.alreadyVoted.get(i).equals(voting1.getUserId())) {
                    flag=1;
                }
            }
            if (flag == 0) {
                voting.setUpvotes(voting.getUpvotes() + 1);
                voting.setDownvotes(voting.getDownvotes());
                voting.setUserId(voting1.getUserId());
                voting.setChallengeId(voting1.getChallengeId());
                voting.setChallengeTitle(voting1.getChallengeTitle());
               // this.alreadyVoted1= voting1.alreadyVoted;
                voting.alreadyVoted.add(voting1.getUserId());
              //  voting.setAlreadyVoted(voting1.getAlreadyVoted());
                System.out.println("hello");
                voting.setFlag(true);
                //voting.setChecking(voting1.getUserId());

                Voting voting2 = votingRepository.save(voting);
                //return voting2;
                votingResource.putIntoTopic(voting);
                return voting2;
            }
            else {

                voting.setUpvotes(voting.getUpvotes());
                voting.setDownvotes(voting.getDownvotes());
                voting.setUserId(voting1.getUserId());
                voting.setChallengeId(voting1.getChallengeId());
                voting.setChallengeTitle(voting1.getChallengeTitle());
                // this.alreadyVoted1= voting1.alreadyVoted;
              //  voting1.alreadyVoted.add(voting1.getUserId());
               // voting.setAlreadyVoted(voting1.getAlreadyVoted());
                //voting.setChecking(voting1.getUserId());

                Voting voting2 = votingRepository.save(voting);
               return voting2;

            }
        }
        else{
            Voting voting2 = new Voting();
            voting2.setUpvotes(1);
            voting2.setDownvotes(0);
            voting2.setUserId(voting1.getUserId());
            voting2.setChallengeId(voting1.getChallengeId());
            voting2.alreadyVoted.add(voting1.getUserId());
            voting2.setChallengeTitle(voting1.getChallengeTitle());
            voting2.setFlag(true);
           // voting2.setAlreadyVoted(voting2.getAlreadyVoted());
           Voting voting3= votingRepository.save(voting2);
           votingResource.putIntoTopic(voting2);
           return  voting3;


        }

    }



    @Override
    public Voting downvoteVotingById( Voting voting1) {
        if (votingRepository.existsById(voting1.getChallengeId())) {
            Voting voting = votingRepository.findById(voting1.getChallengeId()).get();
            int flag = 0;
            for (int i = 0; i < voting.alreadyVoted.size(); i++) {

                if (voting.alreadyVoted.get(i).equals(voting1.getUserId())) {
                    flag=1;
                }
            }
            if (flag == 0) {
                voting.setUpvotes(voting.getUpvotes() );
                voting.setDownvotes(voting.getDownvotes()+1);
                voting.setUserId(voting1.getUserId());
                //voting.setChecking(voting1.getUserId());
                voting.setChallengeId(voting1.getChallengeId());
                // this.alreadyVoted1= voting1.alreadyVoted;
                voting.alreadyVoted.add(voting1.getUserId());
                voting.setChallengeTitle(voting1.getChallengeTitle());
               // voting.setAlreadyVoted(voting1.getAlreadyVoted());
                voting.setFlag(false);
                votingResource.putIntoTopic(voting);

                Voting voting2 = votingRepository.save(voting);
                return voting2;
            } else  {

                voting.setUpvotes(voting.getUpvotes());
                voting.setDownvotes(voting.getDownvotes());
                voting.setUserId(voting1.getUserId());
                voting.setChallengeId(voting1.getChallengeId());
               // voting.setAlreadyVoted(voting.getAlreadyVoted());
                //voting.setChecking(voting1.getUserId());
                 voting.setChallengeTitle(voting1.getChallengeTitle());
                Voting voting2 = votingRepository.save(voting);
                return voting2;

            }

        } else {
            Voting voting2 = new Voting();
            voting2.setUpvotes(0);
            voting2.setDownvotes(1);
            voting2.setUserId(voting1.getUserId());
            voting2.setChallengeId(voting1.getChallengeId());
            voting2.alreadyVoted.add(voting1.getUserId());
            voting2.setChallengeTitle(voting1.getChallengeTitle());
            voting2.setFlag(false);
           // voting2.setAlreadyVoted(voting2.getAlreadyVoted());
            votingRepository.save(voting2);
            votingResource.putIntoTopic(voting2);
            return voting2;
        }




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
    public Voting searchVotingById(String challengeId) {
        Voting voting= votingRepository.findById(challengeId).get();


            return voting;
    }





}

