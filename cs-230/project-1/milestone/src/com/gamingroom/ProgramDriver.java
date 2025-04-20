package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	/**
	 * The main method serves as the entry point for the application.
	 * It demonstrates the use of the singleton pattern by obtaining a reference
	 * to the singleton instance of GameService and initializing some game data.
	 * 
	 * The singleton pattern ensures that a class has only one instance and provides
	 * a global point of access to it. This is useful in this application to ensure
	 * that there is only one instance of GameService managing the game data.
	 * 
	 * Steps performed in this method:
	 * 1. Obtain reference to the singleton instance of GameService.
	 * 2. Print a message indicating the start of game data initialization.
	 * 3. Add two games to the GameService and print their details.
	 * 4. Use another class (SingletonTester) to verify that only one instance of GameService exists.
	 */
	public static void main(String[] args) {
		
		// Obtain reference to the singleton instance
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
