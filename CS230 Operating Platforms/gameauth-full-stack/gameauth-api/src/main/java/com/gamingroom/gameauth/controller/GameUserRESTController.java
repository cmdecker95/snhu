package com.gamingroom.gameauth.controller;

import com.gamingroom.gameauth.auth.GameUser;
import com.gamingroom.gameauth.dao.GameUserDB;
import com.gamingroom.gameauth.representations.GameUserInfo;

import io.dropwizard.auth.Auth;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Server-side HTTP REST API controller.
 * Facilitates CRUD operations on GameUserInfo objects.
 * 
 * CAUTION: GameUser != GameUserInfo
 * 
 * GameUser is a principal in the system, representing user permissions.
 * - id
 * - name
 * - roles
 * GameUserInfo is an object, representing user data.
 * - id
 * - firstName
 * - lastName
 * - email
 */
@Path("/gameusers")
@Produces(MediaType.APPLICATION_JSON)
public class GameUserRESTController {
    private final Validator validator;

    public GameUserRESTController(Validator validator) {
        this.validator = validator;
    }

    /**
     * Retrieves all game users' information.
     */
    @PermitAll
    @GET
    public Response getGameUsers(@Auth GameUser user) {
        return Response.ok(GameUserDB.getGameUsers()).build();
    }

    /**
     * Retrieves a game user's information by ID.
     */
    @RolesAllowed("USER")
    @GET
    @Path("/{id}")
    public Response getGameUserById(@PathParam("id") Integer id, @Auth GameUser user) {
        GameUserInfo gameUserInfo = GameUserDB.getGameUser(id);

        // Return 200 with user info if found
        if (gameUserInfo != null)
            return Response.ok(gameUserInfo).build();

        // Return 404 if user not found
        return Response.status(Status.NOT_FOUND).build();
    }

    /**
     * Creates a new game user.
     */
    @RolesAllowed("ADMIN")
    @POST
    public Response createGameUser(GameUserInfo gameUserInfo, @Auth GameUser user) throws URISyntaxException {

        // Return 400 with validation errors if any
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        if (!violations.isEmpty()) {
            ArrayList<String> validationMessages = new ArrayList<>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }

        // Return 409 if user already exists
        // POST should be used for creating new users only
        if (GameUserDB.getGameUser(gameUserInfo.getId()) != null) {
            return Response.status(Status.CONFLICT)
                    .entity("User with ID " + gameUserInfo.getId() + " already exists. Use PUT to update.")
                    .build();
        }

        // Return 201 with the created user info
        GameUserDB.updateGameUser(gameUserInfo.getId(), gameUserInfo);
        return Response.created(new URI("/gameusers/" + gameUserInfo.getId())).build();
    }

    /**
     * Updates an existing game user by ID.
     */
    @RolesAllowed("ADMIN")
    @PUT
    @Path("/{id}")
    public Response updateGameUserById(@PathParam("id") Integer id, GameUserInfo gameUserInfo) {
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);

        // Return 400 with validation errors if any
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }

        // Return 404 if user not found
        // PUT should be used for updating existing users only
        if (GameUserDB.getGameUser(id) == null) {
            return Response.status(Status.NOT_FOUND)
                    .entity("User with ID " + id + " not found. Use POST to create a new user.")
                    .build();
        }

        // Return 200 with the updated user info
        GameUserDB.updateGameUser(id, gameUserInfo);
        return Response.ok(gameUserInfo).build();
    }

    /**
     * Deletes a game user by ID.
     */
    @RolesAllowed("ADMIN")
    @DELETE
    @Path("/{id}")
    public Response removeGameUserById(@PathParam("id") Integer id) {

        // Return 200 if user is deleted successfully
        if (GameUserDB.getGameUser(id) != null) {
            GameUserDB.removeGameUser(id);
            return Response.ok().build();
        }

        // Return 404 if user not found
        return Response.status(Status.NOT_FOUND).build();
    }
}
