package org.acme;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Inject
    PeopleResource resource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> hello() {
        return resource.list(new Page(5), Sort.by("id"));
    }
}