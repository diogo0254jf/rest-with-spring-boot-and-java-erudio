package com.diogo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diogo.data.vo.v1.PersonVO;
import com.diogo.services.PersonServices;

@RestController
@RequestMapping("/person")
public class personController {

	@Autowired
	PersonServices service;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}

	@ResponseStatus(org.springframework.http.HttpStatus.OK)
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);
	}

	@ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}