package com.gameproject.maddox.service;

import com.gameproject.maddox.model.Game;
import com.gameproject.maddox.model.Review;
import com.gameproject.maddox.repository.GameRepository;
import com.gameproject.maddox.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private GameRepository gameRepository;

    // Method to save a new game review
    public Review addReview(Game game, Integer rating, String content) {
        Game savedGame = gameRepository.save(game);

        Review review = new Review();
        review.setGame(savedGame);
        review.setRating(rating);
        review.setContent(content);
        
        return reviewRepository.save(review);
    }

    // Method to fetch all reviews for a specific game by its ID
    public List<Review> getReviewsByGameId(Long gameId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getGame().getId().equals(gameId))
                .toList();
    }
}