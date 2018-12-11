package com.stackroute.neo4jservice.service.nodeservice;


import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.exception.ConceptNotFoundException;
import com.stackroute.neo4jservice.repository.noderepository.ConceptRepository;
import com.stackroute.neo4jservice.service.nodeservice.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptServiceImpl implements ConceptService {

    ConceptRepository conceptRepository;
    @Autowired
    public ConceptServiceImpl(ConceptRepository conceptRepository) {
        this.conceptRepository = conceptRepository;
    }

    @Override
    public Concept saveConcept(Concept concept) {
        Concept savedConcept = conceptRepository.save(concept);
        return savedConcept;
    }

    @Override
    public String deleteConcept(String id) {
            conceptRepository.deleteById(id);
            return ("Successfully deleted");
        }


    @Override
    public List<Concept> getAllConcepts() {
        return (List<Concept>)conceptRepository.findAll();
    }

    @Override
    public Concept searchConceptByName(String name)
         // throws ConceptNotFoundException
          {
      //if (conceptRepository.findByName(name) != null) {
            Concept searchedConcept = conceptRepository.findByName(name);

            return searchedConcept;
       //
     //else
          //throw new ConceptNotFoundException("Concept Not Found");

    }
//    List<Concept> conceptList=conceptRepository.getAllConcepts();
//    for(int i=0;i<conceptList.size();i++)
//    {
////        if (conceptList(i).getName().equals(name))
    //     Concept searchedConcept=cpnceptList(i);
    //return searchedConcept;
//    }

}
