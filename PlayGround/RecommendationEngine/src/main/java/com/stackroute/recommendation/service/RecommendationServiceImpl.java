package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Challenge;
import com.stackroute.recommendation.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    ChallengeRepository challengeRepository;

    @Autowired
    public RecommendationServiceImpl(ChallengeRepository challengeRepository){
        this.challengeRepository=challengeRepository;
    }

    @Override
    public List<Challenge> getRecommendedChallenges(String name) {

        int countBasic=0;
        int countIntermediate=0;
        int countAdvanced=0;
        List<Challenge> attemptedSolvedChallengeList=challengeRepository.getAttemptedSolvedChallenges(name);
        List<Challenge> recommendedChallengeList=new ArrayList<Challenge>();

        for(int i=0;i<attemptedSolvedChallengeList.size();i++)
        {
            if(attemptedSolvedChallengeList.get(i).getLevel()==1)
                countBasic=countBasic+1;
            else
                if(attemptedSolvedChallengeList.get(i).getLevel()==2)
                    countIntermediate=countIntermediate+1;
                else
                    countAdvanced=countAdvanced+1;
        }
//        System.out.println("......................./fnfjtgjggggggggggggggg.........."+ countIntermediate);
//        System.out.println("......................./fnfjtgjggggggggggggggg.........."+ countBasic);
        if(countBasic<3)

        {
            for(int i=0;i<1;i++)
            {
                recommendedChallengeList.add(challengeRepository.getBasicUnattemptedChallenges(name).get(i));
               // recommendedChallengeList.add(challengeRepository.getBasicUnsolvedChallenge(name).get(i));

            }
        }

        else if(countBasic>=3 && countIntermediate<2)
        {
            //System.out.println("................................."+countIntermediate);
            for(int i=0;i<1;i++) {
                recommendedChallengeList.add(challengeRepository.getIntermediateUnattemptedChallenges(name).get(i));
                //recommendedChallengeList.add(challengeRepository.getIntermediateUnsolvedChallenge(name).get(i));
            }
        }
          else if(countIntermediate>=2)
        {
            //System.out.println("....................hjkkjk..............."+countIntermediate);
            for(int i=0;i<1;i++) {
                recommendedChallengeList.add(challengeRepository.getAdvancedUnattemptedChallenges(name).get(i));
                //recommendedChallengeList.add(challengeRepository.getAdvancedUnsolvedChallenge(name).get(i));
            }
        }

        return recommendedChallengeList;
    }
}
