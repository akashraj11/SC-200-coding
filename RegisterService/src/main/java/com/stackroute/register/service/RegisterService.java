package com.stackroute.register.service;

import com.stackroute.register.domain.User;
import com.stackroute.register.exceptions.NoSuchUserException;
import com.stackroute.register.exceptions.UserNameExistsException;

import java.util.List;

public interface RegisterService {


    public User saveUser(User user) throws UserNameExistsException;
    public List<User> getallUser() throws NoSuchUserException;

}
