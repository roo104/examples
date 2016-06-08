package com.blogspot.jpdevelopment.jerseyswagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services/rest/")
public class RestApplication extends Application {

    protected final Set<Object> singletons = new HashSet<>();
    protected final Set<Class<?>> classes = new HashSet<>();

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();

    public RestApplication() {
        jacksonJsonProvider.setMapper(objectMapper);

        classes.add(PersonService.class);

        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        singletons.add(jacksonJsonProvider);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setBasePath("/services/rest");
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

}
