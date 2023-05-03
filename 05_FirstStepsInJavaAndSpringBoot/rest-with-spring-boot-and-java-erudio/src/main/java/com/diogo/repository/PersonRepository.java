package com.diogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diogo.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}