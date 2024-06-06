package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.userService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> showAllUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{/id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        return new ResponseEntity<> (userService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>editUser(@PathVariable Long id,@RequestBody User user){
        User existingUser = userService.findById(id);
        if(existingUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(id);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
