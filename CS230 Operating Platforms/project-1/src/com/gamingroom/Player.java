package com.gamingroom;

/**
 * A simple class to hold information about a player.
 * 
 * @author coce@snhu.edu
 * @author Christian Decker
 */
public class Player extends Entity {

  /**
   * Constructor with an identifier and name
   */
  public Player(long id, String name) {
    super(id, name); // Calls the Entity(long, String) constructor overload
  }

  @Override
  public String toString() {
    return "Player [id=" + getId() + ", name=" + getName() + "]";
  }
}
