package com.diogo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
