package io.stacktask.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.stacktask.entity.OrganizationEntity;
import io.stacktask.service.AuthenticationService;
import io.stacktask.service.OrganizationService;
import io.stacktask.view.UserViews;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/api/organization")
public class OrganizationResource {
    @Inject
    OrganizationService organizationService;

    @Inject
    AuthenticationService authenticationService;

    @GET
    @Path("/all")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(UserViews.Public.class)
    public Response getAllOrganizations() {
        List<OrganizationEntity> organizationEntities = organizationService.findUserOrganizations(null);
        return Response.ok(organizationEntities).build();
    }

    @POST
    @Path("/create")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(UserViews.Public.class)
    public Response createOrganization(@Context SecurityContext securityContext, OrganizationEntity organizationEntity) {
        organizationEntity.owner = authenticationService.getAuthenticatedUser();
        OrganizationEntity organization = organizationService.persistOrganization(organizationEntity);
        return Response.ok(organization).build();
    }
}
