package com.gameproject.maddox.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class AuthService {

    @Value("${igdb.client-id}")
    private String clientId;

    @Value("${igdb.client-secret}")
    private String clientSecret;

    private String accessToken;

    public String getAccessToken() {
        if (accessToken == null) {
            fetchToken();
        }
        return accessToken;
    }

    private void fetchToken() {
        // Log starting the process
        System.out.println("Fetching new access token from Twitch...");

        String url = "https://id.twitch.tv/oauth2/token?client_id=" + clientId + 
                     "&client_secret=" + clientSecret + 
                     "&grant_type=client_credentials";
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> response = restTemplate.postForObject(url, null, Map.class);
            
            this.accessToken = (String) response.get("access_token");
            System.out.println("Token generated successfully: " + this.accessToken);
        } catch (Exception e) {
            System.err.println("Error fetching token: " + e.getMessage());
        }
    }
}