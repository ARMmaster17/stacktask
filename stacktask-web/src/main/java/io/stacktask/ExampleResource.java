package io.stacktask;

import io.stacktask.model.Greeting;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting hello() {
        return new Greeting("Hello World!");
    }
}