package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * The singleton pattern ensures that only one instance of the GameService class
 * is created throughout the application. This is useful in this context to
 * manage the list of games centrally and ensure consistency.
 * 
 * @author coce@snhu.edu
 * @author Christian Decker
 */
public class GameService {

  /**
   * A list of the active games
   */
  private static List<Game> games = new ArrayList<Game>();

  /**
   * Holds the next game identifier
   */
  private static long nextGameId = 1;

  /**
   * Holds the next player identifier
   */
  private static long nextPlayerId = 1;

  /**
   * Holds the next team identifier
   */
  private static long nextTeamId = 1;

  /**
   * Singleton instance of GameService
   */
  private static GameService service = null;

  /**
   * Private constructor to prevent instantiation
   */
  private GameService() {
  }

  /**
   * Returns the singleton instance of GameService
   * 
   * This method ensures that only one instance of GameService is created. If the
   * instance is null, it creates a new one. Otherwise, it returns the existing
   * instance.
   * 
   * @return the singleton instance of GameService
   */
  public static GameService getService() {
    if (service == null) {
      service = new GameService();
    }
    return service;
  }

  /**
   * Constructs a new game instance
   * 
   * @param name the unique name of the game
   * @return the game instance (new or existing)
   */
  public Game addGame(String name) {
    // check if the game already exists
    Game game = getGame(name);

    // if not found, make a new game instance and add to list of games
    if (game == null) {
      game = new Game(nextGameId++, name);
      games.add(game);
    }

    // return the new/existing game instance to the caller
    return game;
  }

  /**
   * Returns the game at the specified index
   * 
   * @param index the position of the game in the list
   * @return requested game instance or null if index is out of bounds
   */
  Game getGame(int index) {
    if (index >= 0 && index < games.size()) {
      return games.get(index);
    }
    return null;
  }

  /**
   * Returns the game instance with the specified id
   * 
   * @param id unique identifier of game to search for
   * @return requested game instance
   */
  public Game getGame(long id) {
    // a local game instance
    Game game = null;

    // search for the game with the specified id
    for (Game currentGame : games) {
      if (currentGame.getId() == id) {
        game = currentGame;
        break; // Found the game, exit the loop
      }
    }

    return game;
  }

  /**
   * Returns the game instance with the specified name
   * 
   * @param name unique name of game to search for
   * @return requested game instance
   */
  public Game getGame(String name) {
    // a local game instance
    Game game = null;

    // search for the game with the specified name
    for (Game currentGame : games) {
      if (currentGame.getName().equals(name)) {
        game = currentGame;
        break; // Found the game, exit the loop
      }
    }

    return game;
  }

  /**
   * Returns the number of games currently active
   * 
   * @return the number of games currently active
   */
  public int getGameCount() {
    return games.size();
  }

  /**
   * Returns next player id
   * 
   * @return next player id
   */
  public long getNextPlayerId() {
    return nextPlayerId++;
  }

  /**
   * Returns next team id
   * 
   * @return next team id
   */
  public long getNextTeamId() {
    return nextTeamId++;
  }
}