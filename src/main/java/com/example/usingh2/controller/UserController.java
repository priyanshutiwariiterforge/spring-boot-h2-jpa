package com.example.usingh2.controller;

import com.example.usingh2.entity.User;
import com.example.usingh2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //    POST
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //    GET
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}