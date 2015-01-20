package com.blogspot.jpdevelopment.spring.jms.queue;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import com.blogspot.jpdevelopment.mongodb.core.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;


public class PersonQueueConsumer implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonQueueConsumer.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void onMessage(Message message) {
        Person person = (Person) message;
        LOGGER.info("Received message from queue: {}", person);
        this.personRepository.save(person);
    }
}
