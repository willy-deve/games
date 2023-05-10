package com.devsuperior.dslit.services;

import com.devsuperior.dslit.DTO.GameDTO;
import com.devsuperior.dslit.DTO.GameMinDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> getAll() {
        var result= repository.findAll(); //retorna toda minha entidade Game
        var dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = repository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }
}
