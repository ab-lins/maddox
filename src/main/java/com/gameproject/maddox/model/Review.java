package com.gameproject.maddox.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Review() {}

    // --- Getters and Setters ---
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public Game getGame() { return this.game; }
    public void setGame(Game game) { this.game = game; }
    public Integer getRating() { return this.rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getCreatedAt() { return this.createdAt; }
}