package io.stacktask.resource.auth;

import io.stacktask.model.AuthenticationStateModel;
import io.stacktask.service.AuthenticationService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/user")
public class UserResource {

    @Inject
    AuthenticationService authenticationService;

    @GET
    @Path("/state")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response isAuthenticated() {
        return Response
                .ok(
                        new AuthenticationStateModel(
                                authenticationService.userIsAuthenticated()
                        )
                ).build();
    }
}
