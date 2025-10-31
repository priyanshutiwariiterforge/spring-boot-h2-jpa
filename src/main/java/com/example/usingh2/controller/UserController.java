package com.example.usingh2.controller;

import com.example.usingh2.entity.User;
import com.example.usingh2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    PUT
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id ,@RequestBody User updatedUser){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

//    Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}