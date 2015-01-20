package com.blogspot.jpdevelopment.spring.jms.queue;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;

@Component
public class PersonQueueProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonQueueProducer.class);

    @Autowired
    @Qualifier("personJmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendPerson(final Person person) {
        this.jmsTemplate.send(session -> {
            ObjectMessage message = session.createObjectMessage();
            message.setObject(person);
            LOGGER.info("Putting message on queue");
            return message;
        });
    }
}
