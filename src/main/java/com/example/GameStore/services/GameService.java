package com.example.GameStore.services;

import com.example.GameStore.VOs.GameVO;
import com.example.GameStore.exceptions.ResourceNotFoundException;
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
        if(game.isEmpty())
            throw new ResourceNotFoundException("Game not found");
        return game.get();
    }

    public Game CreateGame(GameVO gameVO){
        Game game = new Game(gameVO.getName(), gameVO.getReleaseDate(), gameVO.getAvailableSystems(), gameVO.getPrice(), gameVO.getGenres());
        return gameRepository.save(game);
    }

    public Game updateGame(long id, GameVO gameVO){
        Optional<Game> game = gameRepository.findById(id);
        if(game.isEmpty())
            throw new ResourceNotFoundException("Game not found");
        Game updatedGame = game.get();
        updatedGame.setName(gameVO.getName());
        updatedGame.setAvailableSystems(gameVO.getAvailableSystems());
        updatedGame.setGenres(gameVO.getGenres());
        updatedGame.setPrice(gameVO.getPrice());
        gameRepository.save(updatedGame);
        return updatedGame;
    }


}
