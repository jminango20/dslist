package com.jminango.controllers;

import com.jminango.dto.GameListDTO;
import com.jminango.dto.GameMinDTO;
import com.jminango.dto.ReplacementDTO;
import com.jminango.servicies.GameListService;
import com.jminango.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGamesByList(@PathVariable Long listId) {
        return gameService.findByGameList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@RequestBody ReplacementDTO body, @PathVariable Long listId) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
