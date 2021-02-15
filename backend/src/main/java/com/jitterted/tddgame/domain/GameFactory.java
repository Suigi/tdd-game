package com.jitterted.tddgame.domain;

import java.util.List;

public class GameFactory {

  private final DeckFactory deckFactory;
  private final PlayerFactory playerFactory;

  public GameFactory() {
    this(new DefaultDeckFactory(new CardFactory()), new PlayerFactory());
  }

  public GameFactory(DeckFactory deckFactory, PlayerFactory playerFactory) {
    this.deckFactory = deckFactory;
    this.playerFactory = playerFactory;
  }

  public Game createTwoPlayerGame() {
    List<Player> playerList = playerFactory.createTwoPlayers();
    return new Game(
      playerList,
      deckFactory.createPlayingCardDeck(),
      deckFactory.createTestResultCardDeck()
    );
  }
}
