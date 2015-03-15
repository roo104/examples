package com.blogspot.jpdevelopment.mbean;

import static org.junit.Assert.assertNotNull;

import com.blogspot.jpdevelopment.mbean.config.MBeanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MBeanConfig.class})
public class SpringHelloWorldMBeanImplTest {

    @Autowired
    private MBeanServerConnection clientConnector;

    @Test
    public void testMBeanServerConnection() throws MalformedObjectNameException, IntrospectionException, ReflectionException, InstanceNotFoundException, IOException {
        final Integer mBeanCount = clientConnector.getMBeanCount();
        MBeanInfo beanInfo = clientConnector.getMBeanInfo(new ObjectName("com.blogspot.jpdevelopment" +
                ".mbean:name=SpringHelloWorldMBean"));

        assertNotNull(beanInfo);
    }

}