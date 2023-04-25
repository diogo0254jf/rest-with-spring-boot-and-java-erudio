package com.diogo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.diogo.model.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("finding one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Diogo");
        person.setLastName("Santos");
        person.setAddress("Brasil");
        person.setGender("Undefined");
        return person;
    }

    public List<Person> findAll() {
        logger.info("finding all people");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        logger.info("creating a person");

        return person;
    }

    public Person update(Person person) {
        logger.info("creating a person");

        return person;
    }

    public void delete(String id) {
        logger.info("deleting a person");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Diogo");
        person.setLastName("Santos");
        person.setAddress("Brasil");
        person.setGender("Undefined");
        return person;
    }

}