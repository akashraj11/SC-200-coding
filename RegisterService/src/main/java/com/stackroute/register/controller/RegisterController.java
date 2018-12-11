package com.stackroute.register.controller;


import com.stackroute.register.domain.User;
import com.stackroute.register.exceptions.NoSuchUserException;
import com.stackroute.register.exceptions.UserNameExistsException;
import com.stackroute.register.kafka.producer.UserResource;
import com.stackroute.register.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1")
public class RegisterController {

    RegisterService registerService ;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RegisterController(RegisterService registerService1){
        this.registerService=registerService1;
    }

    @Autowired
    private Environment env;







    @Autowired
    private UserResource userResource;


    @PostMapping("user/add")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        ResponseEntity responseEntity;
        String message = env.getProperty("user-controller.saveUser");
        try
        {
            System.out.println(user.toString());
            //calling method in kafka/producer to send data into kafka topic
            userResource.putIntoTopic(user);
            registerService.saveUser(user);

            System.out.println(user.toString());
            responseEntity = new ResponseEntity<String>(message, HttpStatus.CREATED);

        } catch (UserNameExistsException ex){
            System.out.println("Error 1");
            logger.error(ex.getMessage());
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);
        } catch (Exception ex){
            System.out.println("Error 2");
//            logger.error(ex.getMessage());
            System.out.println(ex);
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);

        }

        return responseEntity;

    }

    @PostMapping("user/addList")
    public ResponseEntity<?> addUserList(@RequestBody List<User> userList){
        ResponseEntity responseEntity;
        String message = env.getProperty("user-controller.saveUser");
        try
        {

            for(User temp:userList){
                registerService.saveUser(temp);
            }
            responseEntity = new ResponseEntity<String>(message,HttpStatus.CREATED);
        }
        catch (UserNameExistsException ex){
            logger.error(ex.getMessage());
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);
        }
        return responseEntity;
    }

    @GetMapping("user/show")
    public ResponseEntity<?> showUsers(){
        ResponseEntity responseEntity;
        try{

            responseEntity = new ResponseEntity<List<User>>(registerService.getallUser(),HttpStatus.OK);

        }
        catch (NoSuchUserException ex){
            logger.error(ex.getMessage());
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);


        }
        catch (Exception ex){
            logger.error(ex.getMessage());
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);

        }
        return responseEntity;
    }
}
