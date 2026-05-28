package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
/**
 * The SingletonTester class is designed to test the singleton pattern implementation
 * of the GameService class.
 * 
 * The singleton pattern ensures that a class has only one instance and provides a global
 * point of access to it. This is useful in scenarios where exactly one object is needed
 * to coordinate actions across the system.
 * 
 * In this application, the GameService class is implemented as a singleton to manage
 * the collection of games. This ensures that there is only one instance of GameService
 * throughout the application, providing a consistent and centralized way to access
 * and manage the games.
 * 
 * The testSingleton method demonstrates how to obtain the singleton instance of
 * GameService and interact with it by printing the list of games.
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// Obtain reference to the singleton instance
		GameService service = GameService.getInstance();
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
