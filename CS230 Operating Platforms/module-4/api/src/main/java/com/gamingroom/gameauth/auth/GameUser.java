package com.gamingroom.gameauth.auth;

import java.security.Principal;
import java.util.Set;

/**
 * A GameUser is a principal in the system, representing a user of the game.
 * 
 * Properties:
 * - id: A unique identifier for the user, generated randomly.
 * - name: The username of the user.
 * - roles: A set of roles assigned to the user.
 */
public class GameUser implements Principal {
    private final int id = (int) (Math.random() * 100);
    private final String name;
    private final Set<String> roles;

    public GameUser(String name) {
        this.name = name;
        this.roles = null;
    }

    public GameUser(String name, Set<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
