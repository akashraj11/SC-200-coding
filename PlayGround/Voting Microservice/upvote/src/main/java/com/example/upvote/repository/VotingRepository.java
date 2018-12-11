package com.example.upvote.repository;


import com.example.upvote.domain.Voting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VotingRepository extends MongoRepository<Voting,Integer> {
   // List<Object> findById(String id);

    //    @Query("SELECT movie FROM Movie movie where movie.movieTitle = :movieTitle")
//    ArrayList<Movie> findBymovieTitle(String movieTitle);
}