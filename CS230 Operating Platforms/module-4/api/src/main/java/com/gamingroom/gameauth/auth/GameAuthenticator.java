package com.gamingroom.gameauth.auth;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Handles game user authentication.
 * 
 * Usernames, passwords, and roles are hardcoded:
 * - guest:password -> []
 * - user:password -> [USER]
 * - player:password -> [USER]
 * - admin:password -> [USER, ADMIN]
 */
public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> {

    // Simulates a database of valid user credentials and their associated roles
    private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
            "guest", ImmutableSet.of(),
            "user", ImmutableSet.of("USER"),
            "player", ImmutableSet.of("USER"),
            "admin", ImmutableSet.of("ADMIN", "USER"));

    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException {
        // Check if the username and password are valid
        boolean validUsername = VALID_USERS.containsKey(credentials.getUsername());
        boolean validPassword = "password".equals(credentials.getPassword());

        // If either the username or password is invalid, return an empty Optional
        if (!validUsername || !validPassword) {
            return Optional.empty();
        }

        // Otherwise, return a new GameUser object with the username and roles
        GameUser user = new GameUser(
                credentials.getUsername(),
                VALID_USERS.get(credentials.getUsername()));

        return Optional.of(user);
    }
}
