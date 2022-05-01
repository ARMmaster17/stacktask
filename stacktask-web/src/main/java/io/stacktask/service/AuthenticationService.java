package io.stacktask.service;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class AuthenticationService {
    @Context
    SecurityContext securityContext;

    public boolean userIsAuthenticated() {
        return securityContext.getUserPrincipal() != null;
    }
}
