package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userAll = userService.getAllUser();
        return ResponseEntity.ok(userAll);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") String userId){
       userService.deleteById(userId);
        return "User Deleted Successfully!!";
    }


}
