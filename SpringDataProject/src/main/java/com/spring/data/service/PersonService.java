package com.spring.data.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.spring.data.domain.Person;

public interface PersonService {
	
	public boolean savePerson(Person p);
	
	public List<Person> fetchAllPerson();

	public Person fetchPerson(Integer id) ;
	

}
