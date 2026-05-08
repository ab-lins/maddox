package com.gameproject.maddox.service;

import com.gameproject.maddox.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {

    @Value("${igdb.client-id}")
    private String clientId;

    // Injecting AuthService to retrieve the access token automatically
    @Autowired
    private AuthService authService;

    public java.util.List<Game> searchGame(String gameName) {
        String url = "https://api.igdb.com/v4/games";
        String token = authService.getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-ID", clientId);
        headers.set("Authorization", "Bearer " + token);
        headers.set("Accept", "application/json");

        // Simple query for now
        String query = "fields id, name, summary, cover.url, total_rating; search \"" + gameName + "\"; where parent_game = null; limit 10;";
        
        HttpEntity<String> request = new HttpEntity<>(query, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Game[]> response = restTemplate.exchange(url, HttpMethod.POST, request, Game[].class);
            Game[] games = response.getBody();
            
            if (games != null && games.length > 0) {
                return java.util.Arrays.asList(games);
            }
        } catch (Exception e) {
            System.err.println("Error searching game: " + e.getMessage());
        }
        return java.util.Collections.emptyList();
    }
}