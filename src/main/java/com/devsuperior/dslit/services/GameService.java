package com.devsuperior.dslit.services;

import com.devsuperior.dslit.DTO.GameDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<GameDTO> getAll() {
        var result= repository.findAll(); //retorna toda minha entidade Game
        var dto = result.stream().map(x -> new GameDTO(x)).toList();
        return dto;
    }
}
