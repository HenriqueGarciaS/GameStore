package com.example.GameStore.controllers;

import com.example.GameStore.models.Game;
import com.example.GameStore.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping()
    public List<Game> findAll(){
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game findbyId(@PathVariable(name = "id") long id){
        return gameService.findById(id);
    }

    @PostMapping()
    public Game createGame(@RequestBody Game game){
        return gameService.CreateGame(game);
    }

}
