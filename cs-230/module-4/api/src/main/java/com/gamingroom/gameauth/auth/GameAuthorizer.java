package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.Authorizer;

import jakarta.ws.rs.container.ContainerRequestContext;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Handles game user authorization.
 */
public class GameAuthorizer implements Authorizer<GameUser> {

    /**
     * Returns whether the user has the specified role.
     */
    @Override
    public boolean authorize(GameUser user, String role, @Nullable ContainerRequestContext requestContext) {
        return user.getRoles() != null && user.getRoles().contains(role);
    }
}
