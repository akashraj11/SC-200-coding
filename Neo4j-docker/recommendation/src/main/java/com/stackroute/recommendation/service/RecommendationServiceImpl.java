package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Challenge;
import com.stackroute.recommendation.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.min;

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
        //System.out.println("..............................." + attemptedSolvedChallengeList);
        List<Challenge> recommendedChallengeList=new ArrayList<Challenge>();
        List<Challenge>recommendedChallengeList1=new ArrayList<Challenge>();
        System.out.println("..............................." + attemptedSolvedChallengeList);

        if(attemptedSolvedChallengeList.size()==0)
        {
//            System.out.println("yghujjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
            for(int i=0;i<challengeRepository.getBasicUnattemptedChallenges1().size();i++)
            {
                recommendedChallengeList.add(challengeRepository.getBasicUnattemptedChallenges1().get(i));

            }
           // return recommendedChallengeList;
            for(int j=0;j<min(3,recommendedChallengeList.size());j++){
                recommendedChallengeList1.add(recommendedChallengeList.get(j));
            }
            return recommendedChallengeList1;
        }
       else {

            for (int i = 0; i < attemptedSolvedChallengeList.size(); i++) {
                if (attemptedSolvedChallengeList.get(i).getLevel() == 1)
                    countBasic = countBasic + 1;
                else if (attemptedSolvedChallengeList.get(i).getLevel() == 2)
                    countIntermediate = countIntermediate + 1;
                else
                    countAdvanced = countAdvanced + 1;
            }
//        System.out.println("......................./fnfjtgjggggggggggggggg.........."+ countIntermediate);
//        System.out.println("......................./fnfjtgjggggggggggggggg.........."+ countBasic);
            if (countBasic < 3) {
                for (int i = 0; i < challengeRepository.getBasicUnattemptedChallenges(name).size(); i++) {
                    recommendedChallengeList.add(challengeRepository.getBasicUnattemptedChallenges(name).get(i));
                    // recommendedChallengeList.add(challengeRepository.getBasicUnsolvedChallenge(name).get(i));

                }
            } else if (countBasic >= 3 && countIntermediate < 2) {
                //System.out.println("................................."+countIntermediate);
                for (int i = 0; i < challengeRepository.getIntermediateUnattemptedChallenges(name).size(); i++) {
                    recommendedChallengeList.add(challengeRepository.getIntermediateUnattemptedChallenges(name).get(i));
                    //recommendedChallengeList.add(challengeRepository.getIntermediateUnsolvedChallenge(name).get(i));
                }
            } else if (countIntermediate >= 2) {
                //System.out.println("....................hjkkjk..............."+countIntermediate);
                for (int i = 0; i < challengeRepository.getAdvancedUnattemptedChallenges(name).size(); i++) {
                    recommendedChallengeList.add(challengeRepository.getAdvancedUnattemptedChallenges(name).get(i));
                    //recommendedChallengeList.add(challengeRepository.getAdvancedUnsolvedChallenge(name).get(i));
                }
            }
        }

        //return recommendedChallengeList;
        for(int j=0;j<min(3,recommendedChallengeList.size());j++){
            recommendedChallengeList1.add(recommendedChallengeList.get(j));
        }
        return recommendedChallengeList1;
    }
}
