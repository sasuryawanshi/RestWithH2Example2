package com.h2demo.RestWithH2Example.RestApi.Controller;


import com.h2demo.RestWithH2Example.RestApi.Dto.UserRequest;
import com.h2demo.RestWithH2Example.RestApi.Entity.User;
import com.h2demo.RestWithH2Example.RestApi.Service.UserService;
import com.h2demo.RestWithH2Example.RestApi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getALlUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody  UserRequest userRequest) {
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody  UserRequest userRequest) {
        service.deleteUser(userRequest);
        return new ResponseEntity( HttpStatus.ACCEPTED);
    }
}
