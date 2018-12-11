package com.stackroute.neo4jservice.service.nodeservice;



import com.stackroute.neo4jservice.domain.nodes.Source;
import com.stackroute.neo4jservice.repository.noderepository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceImpl implements SourceService {

    SourceRepository sourceRepository;

    @Autowired
    public SourceImpl(SourceRepository sourceRepository){
        this.sourceRepository=sourceRepository;
    }
    @Override
    public Source saveSource(Source source) {
//        Challenge savedChallenge = challengeRepository.save(challenge);
//        return savedChallenge;
        Source savedSource=sourceRepository.save(source);
        return savedSource;
    }

    @Override
    public String deleteSource(String id) {
     sourceRepository.deleteById(id);
     return ("Successfully deleted");
    }


    @Override
    public List<Source> getSource() {
        return (List<Source>) sourceRepository.findAll();
    }
}
