package com.blogspot.jpdevelopment.mbean;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jmx.html
 * http://www.springbyexample.org/examples/spring-jmx-code-example.html
 */
@Component
@ManagedResource()
public class SpringHelloWorldMBeanImpl implements SpringHelloWorldMBean {


    @ManagedOperation(description="Greets you with a hello message")
    @Override
    public void sayHello() {

    }

    @ManagedAttribute(description="Who is saying hello?")
    @Override
    public String getName() {
        return null;
    }
}
