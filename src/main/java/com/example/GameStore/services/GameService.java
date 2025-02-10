package com.example.GameStore.services;

import com.example.GameStore.models.Game;
import com.example.GameStore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game findById(Long id){
        Optional<Game> game = gameRepository.findById(id);
        return game.orElseGet(Game::new);
    }

    public Game CreateGame(Game game){
        return gameRepository.save(game);
    }

}
