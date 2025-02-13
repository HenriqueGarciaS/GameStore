package com.example.GameStore.controllers;

import com.example.GameStore.VOs.UserVO;
import com.example.GameStore.models.User;
import com.example.GameStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> findAll() { return ResponseEntity.ok(userService.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(name = "id") long id){ return ResponseEntity.ok(userService.findById(id));}

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserVO user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}
