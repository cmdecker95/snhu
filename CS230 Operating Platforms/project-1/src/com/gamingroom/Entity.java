package com.gamingroom;

/**
 * A simple class to hold information about an entity, which represents the
 * common aspects of a game, team, or player.
 *
 * @author Christian Decker
 */
public class Entity {
  long id;
  String name;

  /**
   * Hide the default constructor to prevent creating empty instances.
   */
  private Entity() {
  }

  /**
   * Constructor with an identifier and name
   */
  public Entity(long id, String name) {
    this();
    this.id = id;
    this.name = name;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  public String toString() {
    return "Entity [id=" + id + ", name=" + name + "]";
  }
}
