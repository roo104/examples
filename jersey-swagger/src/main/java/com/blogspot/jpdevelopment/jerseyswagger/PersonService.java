package com.blogspot.jpdevelopment.jerseyswagger;

import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api
@Path("/person")
public class PersonService {

    private Map<UUID, Person> persons = new HashMap<>();

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Person getPerson(@PathParam("id") String id) {
        return persons.get(UUID.fromString(id));
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createPerson(Person person) {
        UUID id = UUID.randomUUID();
        person.setId(id);
        persons.put(id, person);
        return Response.ok(person).build();
    }

    @GET
    @Path("/id/1")
    @Produces("application/json")
    public Person getPerson() {
        UUID id = UUID.randomUUID();
        Person person = new Person();
        person.setId(id);
        persons.put(id, person);
        return person;
    }
}
