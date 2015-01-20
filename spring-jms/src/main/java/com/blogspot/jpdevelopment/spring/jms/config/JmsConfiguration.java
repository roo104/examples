package com.blogspot.jpdevelopment.spring.jms.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan("com.blogspot.jpdevelopment.spring.jms.queue")
public class JmsConfiguration {

    public static final String PERSON_QUEUE_NAME = "person-queue";
    public static final String BROKER_URL = "tcp://localhost:61616";

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        return connectionFactory;
    }

    @Bean
    public ActiveMQQueue personDestination() {
        return new ActiveMQQueue(PERSON_QUEUE_NAME);
    }

    @Bean
    public JmsTemplate personJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestination(personDestination());
        return jmsTemplate;
    }

}
