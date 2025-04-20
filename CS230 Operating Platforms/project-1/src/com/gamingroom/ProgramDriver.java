package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {

  /**
   * Steps performed in this main method:
   * 
   * 1. Obtain reference to the singleton instance of GameService.
   * 
   * 2. Print a message indicating testing of uniqueness validation.
   * 
   * 3. Test game uniqueness by creating a game and attempting to create a
   * duplicate.
   * 
   * 4. Test team uniqueness by creating a team and attempting to create a
   * duplicate.
   * 
   * 5. Test player uniqueness by creating a player and attempting to create a
   * duplicate.
   * 
   * 6. Add more games, teams, and players to test memory usage.
   * 
   * 7. Use another class (SingletonTester) to verify that only one instance of
   * GameService exists.
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {

    // Obtain reference to the singleton instance
    GameService service = GameService.getService();

    System.out.println("\nTesting uniqueness validation for games, teams, and players...");

    // Test game uniqueness
    Game game1 = service.addGame("GAME 001");
    System.out.println("Successfully created: " + game1);

    // Try to create a game with the same name
    Game duplicateGame = service.addGame("GAME 001");
    System.out.println("Attempted duplicate game: "
        + (duplicateGame == game1 ? "Returned existing game (correct)" : "Created duplicate (wrong)"));

    // Test team uniqueness
    Team team1 = game1.addTeam("TEAM 001");
    System.out.println("Successfully created team: " + team1);

    // Try to create a team with the same name
    Team duplicateTeam = game1.addTeam("TEAM 001");
    System.out.println("Attempted duplicate team: "
        + (duplicateTeam == team1 ? "Returned existing team (correct)" : "Created duplicate (wrong)"));

    // Test player uniqueness
    Player player1 = team1.addPlayer("PLAYER 001");
    System.out.println("Successfully created player: " + player1);

    // Try to create a player with the same name
    Player duplicatePlayer = team1.addPlayer("PLAYER 001");
    System.out.println("Attempted duplicate player: "
        + (duplicatePlayer == player1 ? "Returned existing player (correct)" : "Created duplicate (wrong)"));

    // Add more games, teams, and players to test memory usage
    for (int i = 2; i <= 23; i++) {
      Game game = service.addGame("GAME " + String.format("%03d", i));
      Team team = game.addTeam("TEAM " + String.format("%03d", i));
      team.addPlayer("PLAYER " + String.format("%03d", i));
    }

    // use another class to prove there is only one instance
    SingletonTester tester = new SingletonTester();
    tester.testSingleton();
  }
}
