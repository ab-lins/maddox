package com.gameproject.maddox.controller;

import com.gameproject.maddox.model.Game;
import com.gameproject.maddox.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/games") // Base URL for this controller
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint to search games: GET http://localhost:8080/api/games/search?name=Zelda
    @GetMapping("/search")
    public ResponseEntity<List<Game>> searchGames(@RequestParam String name) {
        // Calls the service we built in Step 2
        List<Game> results = gameService.searchGame(name);
        
        // Returns the list of games with an HTTP 200 OK status
        return ResponseEntity.ok(results);
    }
}