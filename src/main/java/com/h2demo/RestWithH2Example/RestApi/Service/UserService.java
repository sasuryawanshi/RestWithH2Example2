package com.h2demo.RestWithH2Example.RestApi.Service;


import com.h2demo.RestWithH2Example.RestApi.Dto.UserRequest;
import com.h2demo.RestWithH2Example.RestApi.Entity.User;
import com.h2demo.RestWithH2Example.RestApi.Repository.UserRepository;
import com.h2demo.RestWithH2Example.RestApi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User saveUser(UserRequest userRequest) {
        User user = User.
                build(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile());
        return repository.save(user);
    }


    public List<User> getALlUsers() {
        return repository.findAll();
    }


    public User getUser(int id)  throws UserNotFoundException {
        User user= repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
           throw new UserNotFoundException("user not found with id : "+id);
        }

    }


    public void deleteUser(UserRequest userRequest) {
        User user = User.
                build(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile());
         repository.deleteById(user.getUserId());
    }
}
