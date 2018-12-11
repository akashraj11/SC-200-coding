package com.stackroute.neo4jservice.Controller.relationcontroller;

import com.stackroute.neo4jservice.domain.datamodel.DataModelForAttempt;
import com.stackroute.neo4jservice.domain.datamodel.DataModelForPost;
import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.relation.Attempt;
import com.stackroute.neo4jservice.domain.relation.TypeRelation;
import com.stackroute.neo4jservice.exception.ConceptNotFoundException;
import com.stackroute.neo4jservice.service.nodeservice.ConceptService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.AttemptService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AttemptController {
    private AttemptService attemptService;
    private TypeService typeService;
    private ConceptService conceptService;

    @Autowired
    public AttemptController(AttemptService attemptService, TypeService typeService, ConceptService conceptService) {
        this.attemptService = attemptService;
        this.typeService = typeService;
        this.conceptService = conceptService;
    }
//    @Autowired
//    public AttemptController(AttemptService attemptService) {
//        this.attemptService = attemptService;
//    }

//    @PostMapping("attempt")
//    public ResponseEntity<?> saveAttempt(@RequestBody Attempt attempt) {
//        ResponseEntity responseEntity;
//        Attempt savedAttempt = attemptService.saveAttempt(attempt);
//
//        responseEntity = new ResponseEntity<Attempt>(savedAttempt, HttpStatus.CREATED);
//
//        return responseEntity;
//    }
        @PostMapping("attempt")
    public ResponseEntity<?> saveAttempt(@RequestBody DataModelForAttempt data) {
        ResponseEntity responseEntity;
        Concept searchedConcept=null;
        // create a attempt object from data
        Attempt attempt = new Attempt();
        attempt.setId(data.getId());
        attempt.setScore(data.getScore());
        attempt.setDate(java.util.Calendar.getInstance().getTime());
        attempt.setStatus(data.getStatus());
        attempt.setChallenge(data.getChallenge());
        attempt.setUser(data.getUser());
        // save this attempt object in database
        Attempt savedAttempt = attemptService.saveAttempt(attempt);

        // write the logic to fefth the concept from the database based on the concept name
        // Concept concept = repo.getConcept("name");
        String conceptName=data.getConceptName();
       // try {
            searchedConcept = conceptService.searchConceptByName(conceptName);
      //  }
       // catch(ConceptNotFoundException e)
       // {
           // responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
      //  }
        // create a type relation to connect two nodes concept and challange
        TypeRelation tr = new TypeRelation();
        tr.setChallenge(data.getChallenge());
        tr.setConcept(searchedConcept);
            TypeRelation savedTypeRelation=typeService.saveTypeRelation(tr);
            System.out.println("....................in controller......."+savedTypeRelation);
        responseEntity = new ResponseEntity<Attempt>(savedAttempt, HttpStatus.CREATED);
        return responseEntity;
//        Attempt savedAttempt = attemptService.saveAttempt(attempt);
//
//        responseEntity = new ResponseEntity<Attempt>(savedAttempt, HttpStatus.CREATED);

       //  return responseEntity;
    }

    @GetMapping("attempt")
    public ResponseEntity<?> getAllAttempts()
    {
        List<Attempt> attemptList;
        attemptList=attemptService.getAllAttempts();
        ResponseEntity responseEntity=new ResponseEntity<List<Attempt>>(attemptList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("attempt/{id}")
    public ResponseEntity<?> deleteAttempt(@PathVariable("id") String id) {
        List<Attempt> attemptList;
        ResponseEntity responseEntity;
        String message = attemptService.deleteAttempt(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
