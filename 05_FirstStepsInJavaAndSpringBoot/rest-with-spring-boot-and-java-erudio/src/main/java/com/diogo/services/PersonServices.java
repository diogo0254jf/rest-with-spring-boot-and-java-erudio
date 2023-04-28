package com.diogo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.data.vo.v1.PersonVO;
import com.diogo.exeptions.ResourceNotFoundException;
import com.diogo.interfaces.PersonRepository;
import com.diogo.mapper.DozerMapper;
import com.diogo.model.Person;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public PersonVO findById(Long id) {
        logger.info("finding one person");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found person with id"));
    return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("finding all people");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("creating a person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("creating a person");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found person with id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {

        logger.info("deleting a person");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found person with id"));

        repository.delete(entity);
    }
}