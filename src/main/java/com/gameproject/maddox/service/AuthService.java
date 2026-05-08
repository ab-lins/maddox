package com.gameproject.maddox.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gameproject.maddox.model.TwitchAuthResponse;

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
        System.out.println("Fetching new access token from Twitch...");

        String url = "https://id.twitch.tv/oauth2/token?client_id=" + clientId + 
                     "&client_secret=" + clientSecret + 
                     "&grant_type=client_credentials";
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            
            TwitchAuthResponse response = restTemplate.postForObject(url, null, TwitchAuthResponse.class);
            
            if (response != null) {
                this.accessToken = response.getAccessToken();
                System.out.println("Token generated successfully: " + this.accessToken);
            }
        } catch (Exception e) {
            System.err.println("Error fetching token: " + e.getMessage());
        }
    }
}