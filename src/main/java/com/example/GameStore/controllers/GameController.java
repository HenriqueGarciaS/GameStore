package com.example.GameStore.controllers;

import com.example.GameStore.VOs.GameVO;
import com.example.GameStore.models.Game;
import com.example.GameStore.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping()
    public ResponseEntity<List<Game>> findAll(){
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable(name = "id") long id){

        return ResponseEntity.ok(gameService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Game> createGame(@RequestBody GameVO game){
        return new ResponseEntity<>(gameService.CreateGame(game), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable(name = "id") long id, @RequestBody GameVO game){
        return ResponseEntity.ok(gameService.updateGame(id, game));
    }

}
