package com.stackroute.neo4jservice.service.relationservice.serviceimpl;

import com.stackroute.neo4jservice.domain.relation.Post;
import com.stackroute.neo4jservice.domain.relation.TypeRelation;
import com.stackroute.neo4jservice.repository.relationrepository.PostRepository;
import com.stackroute.neo4jservice.repository.relationrepository.TypeRepository;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    TypeRepository typeRepository;
    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository)
    {
        this.typeRepository=typeRepository;
    }

    @Override
    public TypeRelation saveTypeRelation(TypeRelation typeRelation) {
        TypeRelation savedTypeRelation = typeRepository.save(typeRelation);
        System.out.println("...............in type relation........."+ savedTypeRelation);
        return savedTypeRelation;
    }

    @Override
    public String deleteTypeRelation(String id) {
        typeRepository.deleteById(id);
        return ("Successfully deleted");
    }

    @Override
    public List<TypeRelation> getAllTypeRelation() {
        return (List<TypeRelation>)typeRepository.findAll();
    }
}
