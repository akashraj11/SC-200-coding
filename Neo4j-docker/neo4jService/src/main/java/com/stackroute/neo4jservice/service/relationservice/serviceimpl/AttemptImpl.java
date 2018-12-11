package com.stackroute.neo4jservice.service.relationservice.serviceimpl;

import com.stackroute.neo4jservice.domain.relation.Attempt;

import com.stackroute.neo4jservice.repository.relationrepository.AttemptRepository;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttemptImpl implements AttemptService {
    AttemptRepository attemptRepository;
    @Autowired
    public AttemptImpl(AttemptRepository attemptRepository)
    {
        this.attemptRepository=attemptRepository;
    }
    @Override
    public Attempt saveAttempt(Attempt attempt) {
        Attempt savedAttempt = attemptRepository.save(attempt);
        return savedAttempt;
    }

    @Override
    public String deleteAttempt(String id) {
        attemptRepository.deleteById(id);
        return ("Successfully deleted");
    }

    @Override
    public List<Attempt> getAllAttempts() {
        return (List<Attempt>)attemptRepository.findAll();

    }

    public static class PartOfRelationImpl {
    }
}
