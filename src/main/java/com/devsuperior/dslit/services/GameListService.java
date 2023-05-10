package com.devsuperior.dslit.services;


import com.devsuperior.dslit.DTO.GameListDTO;
import com.devsuperior.dslit.DTO.GameMinDTO;
import com.devsuperior.dslit.repositories.GameListRepository;
import com.devsuperior.dslit.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;


    @Transactional(readOnly = true)
    public List<GameListDTO> getAll() {
        var result= repository.findAll(); //retorna minha lista
        var dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

}
