package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team.
 * 
 * @author coce@snhu.edu
 * @author Christian Decker
 */
public class Team extends Entity {

  /**
   * Singleton instance of GameService
   */
  private static GameService service = GameService.getService();

  /**
   * A list of the active players
   */
  private List<Player> players = new ArrayList<Player>();

  /**
   * Constructor with an identifier and name
   */
  public Team(long id, String name) {
    super(id, name); // Calls the Entity(long, String) constructor overload
  }

  /**
   * Adds a player to the team
   * 
   * @param name the unique name of the player
   * @return the player instance (new or existing)
   */
  public Player addPlayer(String name) {
    // check if the player already exists
    for (Player currentPlayer : players) {
      if (currentPlayer.getName().equals(name)) {
        return currentPlayer;
      }
    }

    // if not found, make a new player instance and add to list of players
    Player player = new Player(service.getNextPlayerId(), name);
    players.add(player);

    // return the new/existing player instance to the caller
    return player;
  }

  @Override
  public String toString() {
    return "Team [id=" + getId() + ", name=" + getName() + "]";
  }
}
