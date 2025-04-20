package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game.
 * 
 * @author coce@snhu.edu
 * @author Christian Decker
 */
public class Game extends Entity {

  /**
   * Singleton instance of GameService
   */
  private static GameService service = GameService.getService();

  /**
   * A list of the active teams
   */
  private static List<Team> teams = new ArrayList<Team>();

  /**
   * Constructor with an identifier and name
   */
  public Game(long id, String name) {
    super(id, name); // Calls the Entity(long, String) constructor overload
  }

  /**
   * Adds a team to the game
   * 
   * @param name the unique name of the team
   * @return the team instance (new or existing)
   */
  public Team addTeam(String name) {
    // check if the team already exists
    for (Team currentTeam : teams) {
      if (currentTeam.getName().equals(name)) {
        return currentTeam;
      }
    }

    // if not found, make a new team instance and add to list of teams
    Team team = new Team(service.getNextTeamId(), name);
    teams.add(team);

    // return the new/existing team instance to the caller
    return team;
  }

  @Override
  public String toString() {
    return "Game [id=" + getId() + ", name=" + getName() + "]";
  }
}
