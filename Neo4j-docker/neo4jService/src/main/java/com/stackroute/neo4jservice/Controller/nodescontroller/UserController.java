package com.stackroute.neo4jservice.Controller.nodescontroller;

import com.stackroute.neo4jservice.domain.nodes.Challenge;
import com.stackroute.neo4jservice.domain.nodes.User;
import com.stackroute.neo4jservice.service.nodeservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        User savedUser;
        boolean userExistence=userService.checkForUserExistence(user);
        if(userExistence==false)
        {
            savedUser = userService.saveUser(user);
            responseEntity = new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        }
        else {
            //get the user by id and send it as response entity
            savedUser = userService.searchById(user);
            responseEntity = new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        }

        return responseEntity;
    }
    @GetMapping("user")
    public ResponseEntity<?> getAllUser()
    {
        List<User> userList;
        userList=userService.getAllUser();
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(userList,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        List<User> userList;
        ResponseEntity responseEntity;
        String message = userService.deleteUser(id);
        responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        return responseEntity;
    }
}
