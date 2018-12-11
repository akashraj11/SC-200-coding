package com.stackroute.neo4jservice.service.relationservice.serviceimpl;

import com.stackroute.neo4jservice.domain.relation.Post;
import com.stackroute.neo4jservice.domain.relation.SubPartRelation;
import com.stackroute.neo4jservice.repository.relationrepository.PostRepository;
import com.stackroute.neo4jservice.repository.relationrepository.SubPartRepository;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.SubPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubPartServiceImpl implements SubPartService {
    SubPartRepository subPartRepository;
    @Autowired
    public SubPartServiceImpl(SubPartRepository subPartRepository)
    {
        this.subPartRepository=subPartRepository;
    }

    @Override
    public SubPartRelation saveSubPartRelation(SubPartRelation subPartRelation) {
        SubPartRelation savedSubPartRelation = subPartRepository.save(subPartRelation);
        return savedSubPartRelation;
    }

    @Override
    public String deleteSubPart(String id) {
        subPartRepository.deleteById(id);
        return ("Successfully deleted");
    }

    @Override
    public List<SubPartRelation> getAllSubPartRelation() {
        return (List<SubPartRelation>)subPartRepository.findAll();
    }
}
