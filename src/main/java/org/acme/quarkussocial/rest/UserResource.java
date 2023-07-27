package org.acme.quarkussocial.rest;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.quarkussocial.domain.model.User;
import org.acme.quarkussocial.rest.dto.CreateUserRequest;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Transactional
     public Response createUser(CreateUserRequest request) {

        User user = new User();
        user.setAge(request.getAge());
        user.setName(request.getName());

        user.persist();
        return Response.ok(user).build();
     }

     @GET
    public Response listAllUsers() {
         PanacheQuery<User> query = User.findAll();
         return Response.ok(query.list()).build();
     }

}
