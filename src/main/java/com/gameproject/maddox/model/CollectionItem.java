package com.gameproject.maddox.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collection_items")
public class CollectionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    public CollectionItem() {}

    // --- Getters and Setters ---
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public Game getGame() { return this.game; }
    public void setGame(Game game) { this.game = game; }
    public GameStatus getStatus() { return this.status; }
    public void setStatus(GameStatus status) { this.status = status; }
}