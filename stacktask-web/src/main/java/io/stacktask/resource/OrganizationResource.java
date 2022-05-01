package io.stacktask.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.stacktask.entity.OrganizationEntity;
import io.stacktask.service.OrganizationService;
import io.stacktask.view.UserViews;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/organization")
public class OrganizationResource {
    @Inject
    OrganizationService organizationService;

    @GET
    @Path("/all")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(UserViews.Public.class)
    public Response getAllOrganizations() {
        List<OrganizationEntity> organizationEntities = organizationService.findUserOrganizations(null);
        return Response.ok(organizationEntities).build();
    }
}
