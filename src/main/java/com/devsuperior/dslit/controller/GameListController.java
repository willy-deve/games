package com.devsuperior.dslit.controller;

import com.devsuperior.dslit.DTO.GameDTO;
import com.devsuperior.dslit.DTO.GameListDTO;
import com.devsuperior.dslit.DTO.GameMinDTO;
import com.devsuperior.dslit.services.GameListService;
import com.devsuperior.dslit.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> getAll() {
        var result = service.getAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> getAllList(@PathVariable Long listId) {
        var result = gameService.getAlllist(listId);
        return result;
    }



}
