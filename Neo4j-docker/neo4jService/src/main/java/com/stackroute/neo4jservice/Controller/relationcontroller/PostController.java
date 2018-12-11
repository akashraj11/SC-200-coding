package com.stackroute.neo4jservice.Controller.relationcontroller;

import com.stackroute.neo4jservice.domain.nodes.Concept;
import com.stackroute.neo4jservice.domain.datamodel.DataModelForPost;
import com.stackroute.neo4jservice.domain.relation.Post;
import com.stackroute.neo4jservice.domain.relation.TypeRelation;
import com.stackroute.neo4jservice.exception.ConceptNotFoundException;
import com.stackroute.neo4jservice.service.nodeservice.ConceptService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.PostService;
import com.stackroute.neo4jservice.service.relationservice.serviceinterface.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PostController {
    private PostService postService;
    private TypeService typeService;
    private ConceptService conceptService;

    @Autowired
    public PostController(PostService postService, TypeService typeService, ConceptService conceptService) {
        this.postService = postService;
        this.typeService = typeService;
        this.conceptService = conceptService;
    }
//    @Autowired
//    public PostController(PostService postService,) {
//        this.postService = postService;
//    }

//    @PostMapping("post")
//    public ResponseEntity<?> savePost(@RequestBody Post post) {
//        ResponseEntity responseEntity;
//        System.out.println("........................in controller..........................................."+post);
//        Post savedPost = postService.savePost(post);
//        responseEntity = new ResponseEntity<Post>(savedPost, HttpStatus.CREATED);
//        return responseEntity;
//        }
    @PostMapping("post")
    public ResponseEntity<?> savePost(@RequestBody DataModelForPost data) {
        ResponseEntity responseEntity;
        Concept searchedConcept=null;
        // create a post object from data
        Post post = new Post();
        post.setId(data.getId());

        post.setDate(java.util.Calendar.getInstance().getTime());
        //System.out.println("......in controller......."+post.getId());
        post.setChallenge(data.getChallenge());
        post.setUser(data.getUser());
        // save this post object in database
        Post savedPost = postService.savePost(post);

        // write the logic to fefth the concept from the database based on the concept name
        // Concept concept = repo.getConcept("name");
        String conceptName=data.getConceptName();

       // try {
            searchedConcept = conceptService.searchConceptByName(conceptName);

       // }
        //catch(ConceptNotFoundException e)
      //  {
           // responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
    //}
        // create a type relation to connect two nodes concept and challange
        TypeRelation tr = new TypeRelation();
        tr.setChallenge(data.getChallenge());
        tr.setConcept(searchedConcept);
       // System.out.println("....................in controller........"+ tr);
        TypeRelation savedTypeRelation=typeService.saveTypeRelation(tr);
        System.out.println("....................in controller......."+savedTypeRelation);
        responseEntity = new ResponseEntity<Post>(savedPost, HttpStatus.CREATED);
        return responseEntity;

    }




        //tr.setId();
        //tr.setName(data.getName());
//        tr.setChallenge(data.getChallenge());
//        tr.setConcept(concept);

        // write the logic to save the typerelation in database
//        typeService.saveTypeRelation()

//        System.out.println("saved post from controller is.............."+ savedPost1);
//        responseEntity = new ResponseEntity<Post>(savedPost1, HttpStatus.CREATED);


    @GetMapping("post")
    public ResponseEntity<?> getAllPosts()
    {
        List<Post> postList;
        postList=postService.getAllPosts();
        ResponseEntity responseEntity=new ResponseEntity<List<Post>>(postList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") int id) {
        List<Post> postList;
        ResponseEntity responseEntity;
        String message = postService.deletePost(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
