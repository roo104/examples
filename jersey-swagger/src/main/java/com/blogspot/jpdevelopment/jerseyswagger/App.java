package com.blogspot.jpdevelopment.jerseyswagger;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@ApplicationPath("rest")
public class App extends ResourceConfig {
    public App() {
        packages("com.blogspot");
    }

    @Path("example")
    public static class Hello {

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<String> example() {
            List<String> l = new ArrayList<>();
            l.add("one");
            l.add("two");
            return l;
        }

    }

}