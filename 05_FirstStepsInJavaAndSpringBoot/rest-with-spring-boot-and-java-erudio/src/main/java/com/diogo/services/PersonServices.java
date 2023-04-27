package com.diogo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.exeptions.ResourceNotFoundException;
import com.diogo.interfaces.PersonRepository;
import com.diogo.model.Person;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id) {
        logger.info("finding one person");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found person with id"));
    }

    public List<Person> findAll() {
        logger.info("finding all people");

        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("creating a person");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("creating a person");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found person with id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {

        logger.info("deleting a person");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found person with id"));

        repository.delete(entity);
    }
}