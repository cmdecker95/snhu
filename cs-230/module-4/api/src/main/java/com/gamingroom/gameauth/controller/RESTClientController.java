package com.gamingroom.gameauth.controller;

import com.gamingroom.gameauth.representations.GameUserInfo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Produces(MediaType.TEXT_PLAIN)
@Path("/client")
public class RESTClientController {
    private static final String BASE_URL = "http://localhost:8080";
    private Client client;

    public RESTClientController(Client client) {
        this.client = client;
    }

    @GET
    @Path("/gameusers")
    public String getGameUsers(@jakarta.ws.rs.core.Context jakarta.ws.rs.core.HttpHeaders headers) {
        String authHeader = headers.getHeaderString("Authorization");
        WebTarget webTarget = client.target(BASE_URL + "/gameusers");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
                .header("Authorization", authHeader);
        Response response = invocationBuilder.get();
        @SuppressWarnings("rawtypes")
        ArrayList gameusers = response.readEntity(ArrayList.class);
        return gameusers.toString();
    }

    @GET
    @Path("/gameusers/{id}")
    public String getGameUserById(@PathParam("id") int id,
            @jakarta.ws.rs.core.Context jakarta.ws.rs.core.HttpHeaders headers) {
        String authHeader = headers.getHeaderString("Authorization");
        WebTarget webTarget = client.target(BASE_URL + "/gameusers/" + id);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
                .header("Authorization", authHeader);
        Response response = invocationBuilder.get();
        GameUserInfo gameUserInfo = response.readEntity(GameUserInfo.class);
        return gameUserInfo.toString();
    }
}
