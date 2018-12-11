package com.stackroute.register.service;

import com.stackroute.register.domain.User;
import com.stackroute.register.exceptions.NoSuchUserException;
import com.stackroute.register.exceptions.UserNameExistsException;
import com.stackroute.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {


    UserRepository userRepository;


    @Autowired
    public RegisterServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Autowired
    private Environment env;



    @Override
    public User saveUser(User user) throws UserNameExistsException {
        if(userRepository.existsById(user.getEmail())){

            String message = env.getProperty("user-service.impl.usernameEx");

            throw new UserNameExistsException(message);
        }
        User savedUser = userRepository.save(user);
        //check for null and user exist exception
        return savedUser;
    }
    @Override
    public List<User> getallUser() throws NoSuchUserException{
        List<User> userList = userRepository.findAll();
        String message = env.getProperty("user-service.impl.nouserEx");
        if(userList.isEmpty()){
            throw new NoSuchUserException(message);
        }
        return userList;
    }



}
