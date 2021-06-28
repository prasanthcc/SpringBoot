package com.spring.data.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.domain.Person;
import com.spring.data.respository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	
	@Autowired
	private PersonRepository repository;
	
	@Override
	public boolean savePerson(Person p) {
		
		Person p1 = repository.save(p);
		
		return true;
		
	}

	@Override
	public List<Person> fetchAllPerson() {
		// TODO Auto-generated method stub
		
		Iterable<Person> list = repository.findAll();
		
		return (List<Person>) list;
	}
	
	
	@Override
	public Person fetchPerson(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Person> person = repository.findById(id);
		
		if(person.isPresent()) {
			return person.get();
		}else {
		return person.orElseThrow();
		}
		
	}

	public PersonRepository getRepository() {
		return repository;
	}

	public void setRepository(PersonRepository repository) {
		this.repository = repository;
	}
	
	

}
