package com.example.GameStore.controllers;

import com.example.GameStore.VOs.UserVO;
import com.example.GameStore.models.User;
import com.example.GameStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> findAll() { return userService.findAll(); }

    @GetMapping("/{id}")
    public User findById(@PathVariable(name = "id") long id){ return userService.findById(id);}

    @PostMapping()
    public User createUser(@RequestBody UserVO user){
        return userService.createUser(user);
    }
}
