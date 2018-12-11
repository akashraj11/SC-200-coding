package com.stackroute.neo4jservice.service.relationservice.serviceimpl;


import com.stackroute.neo4jservice.domain.nodes.Language;
import com.stackroute.neo4jservice.domain.relation.IsARelation;

import com.stackroute.neo4jservice.repository.relationrepository.IsARepository;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.IsARelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class IsARelationImpl implements IsARelationService {
    IsARepository isARepository;
    @Autowired
    public IsARelationImpl(IsARepository isARepository)
    {
        this.isARepository=isARepository;
    }

    @Override
    public IsARelation saveIsARelation(IsARelation isARelation) {
        IsARelation savedIsARelation = isARepository.save(isARelation);
        return savedIsARelation;
    }

    @Override
    public String deleteIsARelation(String id) {
        isARepository.deleteById(id);
        return ("Successfully deleted");
    }

    @Override
    public List<IsARelation> getAllIsARelation() {
        System.out.println("inside the service findall");
        List<IsARelation> realtionList = (List<IsARelation>) isARepository.findAll();
        System.out.println(realtionList);
        return realtionList;
    }
//    @Override
//    public IsARelation getAllIsARelation() {
//        return (List<IsARelation>)isARepository.findAll();
//    }
//    @Override
//    public List<Language> getAllIsARelation() {
//        return (List<Language>)isARepository.findAll();
//    }
}
