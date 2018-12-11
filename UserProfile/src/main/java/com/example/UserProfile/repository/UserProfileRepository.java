package com.example.UserProfile.repository;

import com.example.UserProfile.domain.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile,String> {

}

