package com.blogspot.jpdevelopment.jerseyswagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.swagger.jaxrs.config.BeanConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestApplication extends Application {

    protected final Set<Object> singletons = new HashSet<>();
    protected final Set<Class<?>> classes = new HashSet<>();

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();

    public RestApplication() {
        classes.add(PersonService.class);

        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
//        beanConfig.setHost("http://localhost:9001");
        beanConfig.setBasePath("/services/rest/");
        beanConfig.setVersion("1.0");
        beanConfig.setTitle("API");
        beanConfig.setDescription("desc");
        beanConfig.setResourcePackage("com.blogspot.jpdevelopment.jerseyswagger");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    public static void main(String args[]) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/services/rest/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("javax.ws.rs.Application", RestApplication.class.getName());

        Server httpServer = new Server(9001);
        httpServer.setHandler(context);
        httpServer.start();
    }
}
