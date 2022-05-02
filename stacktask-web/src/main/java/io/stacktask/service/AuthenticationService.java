package io.stacktask.service;


import io.stacktask.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class AuthenticationService {
    @Context
    SecurityContext securityContext;

    @Inject
    UserService userService;

    public boolean userIsAuthenticated() {
        return securityContext.getUserPrincipal() != null;
    }

    public User getAuthenticatedUser() {
        return userService.getUser(securityContext.getUserPrincipal().getName());
    }
}
