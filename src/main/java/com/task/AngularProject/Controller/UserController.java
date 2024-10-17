package com.task.AngularProject.Controller;

import com.task.AngularProject.Entity.User;
import com.task.AngularProject.Service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User saveUser = service.saveUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }
    @GetMapping("/users/login")
    public User getUserbyName(@RequestParam String username, @RequestParam String password){
    	return service.getUserbyName(username, password);
    }
    
    @GetMapping("allusers")
    public ResponseEntity<List<User>> getUser(){
    	return new ResponseEntity<>(service.findAllUser(),HttpStatus.FOUND);
    }
}
