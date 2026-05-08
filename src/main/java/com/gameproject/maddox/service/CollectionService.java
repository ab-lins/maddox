package com.gameproject.maddox.service;

import com.gameproject.maddox.model.CollectionItem;
import com.gameproject.maddox.model.Game;
import com.gameproject.maddox.model.GameStatus;
import com.gameproject.maddox.repository.CollectionItemRepository;
import com.gameproject.maddox.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CollectionItemRepository collectionRepository;

    // Add a game to the collection (Wishlist or Played)
    public CollectionItem addGameToCollection(Game game, GameStatus status) {
        Game savedGame = gameRepository.save(game);

        CollectionItem item = new CollectionItem();
        item.setGame(savedGame);
        item.setStatus(status);

        return collectionRepository.save(item);
    }

    // Fetch all games from a specific list (by status)
    public List<CollectionItem> getCollectionByStatus(GameStatus status) {
        return collectionRepository.findAll().stream()
                .filter(item -> item.getStatus() == status)
                .toList();
    }
}