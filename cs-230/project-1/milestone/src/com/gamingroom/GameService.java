package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * The singleton pattern ensures that only one instance of the GameService class
 * is created throughout the application. This is useful in this context to 
 * manage the list of games centrally and ensure consistency.
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/**
	 * Singleton instance
	 * 
	 * This static variable holds the single instance of GameService.
	 */
	private static GameService instance = null;

	/**
	 * Returns the singleton instance of GameService
	 * 
	 * This method ensures that only one instance of GameService is created.
	 * If the instance is null, it creates a new one. Otherwise, it returns the
	 * existing instance.
	 * 
	 * @return the singleton instance of GameService
	 */
	public static GameService getInstance() {
		if (instance == null) {
			instance = new GameService();
		}
		return instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {
		// a local game instance
		Game game = null;

		/* 
		 * Iterator Pattern Implementation:
		 * Using an explicit iterator to traverse the collection of games.
		 * 
		 * The Iterator pattern provides a way to access elements of a collection
		 * sequentially without exposing the underlying structure. This is useful
		 * in our multi-user game application to check if a game name already exists
		 * before creating a new one, ensuring uniqueness across all game instances.
		 * 
		 * Benefits in this context:
		 * 1. Encapsulation: Shields the client from the internal collection implementation
		 * 2. Simplicity: Provides a uniform way to traverse different collections
		 * 3. Single Responsibility: Separates the traversal logic from the collection
		 */
		Iterator<Game> iterator = games.iterator();
		while (iterator.hasNext()) {
			Game existingGame = iterator.next();
			if (existingGame.getName().equals(name)) {
				return existingGame; // Found a game with the same name, return it
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		// Direct access is appropriate here since we're accessing by index
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {
		// a local game instance
		Game game = null;

		/* 
		 * Iterator Pattern Implementation:
		 * Using the iterator to search through games collection by ID.
		 * 
		 * This demonstrates the iterator's capability to traverse elements
		 * sequentially while allowing us to check a condition (ID match)
		 * for each element without concerning ourselves with how the
		 * list is implemented internally.
		 */
		Iterator<Game> iterator = games.iterator();
		while (iterator.hasNext()) {
			Game currentGame = iterator.next();
			if (currentGame.getId() == id) {
				game = currentGame;
				break; // Found the game, exit the loop
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {
		// a local game instance
		Game game = null;

		/* 
		 * Iterator Pattern Implementation:
		 * Using the iterator to search through games collection by name.
		 * 
		 * This method is crucial for our multi-user application, as it allows
		 * retrieval of game instances by their unique name - supporting features
		 * like rejoining games or checking for duplicates when saving.
		 * 
		 * The iterator allows us to safely traverse the collection even if it
		 * changes structure in future implementations (e.g., if we switch from
		 * ArrayList to another collection type).
		 */
		Iterator<Game> iterator = games.iterator();
		while (iterator.hasNext()) {
			Game currentGame = iterator.next();
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
}