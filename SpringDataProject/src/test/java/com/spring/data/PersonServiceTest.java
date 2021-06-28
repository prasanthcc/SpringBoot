package com.spring.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.data.domain.Person;
import com.spring.data.respository.PersonRepository;
import com.spring.data.service.PersonServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	
	 private PersonServiceImpl personService;
		
	 @Mock
	  private PersonRepository personRepository;
	 
	  @BeforeEach
	    void initUseCase() {
		  personService = new PersonServiceImpl();
		  personService.setRepository(personRepository);
	    }
	
	
	
	 @Test
	    public void savedPerson_Success() {
	        Person person = new Person();
	        person.setEmailId("prasanth.srmist@gmail.com");
	        person.setId(1L);
	        person.setName("Prasanth");
	        when(personRepository.save(person)).thenReturn(person);
	        Person savedCustomer = personRepository.save(person);
	        assertThat(savedCustomer.getName()).isNotNull();
	        assertThat(savedCustomer.getName()).isEqualTo("Prasanth");

	    }
	 
	 @Test
	    public void person_exists_in_db_success() {
		 	Person person = new Person();
	        person.setEmailId("prasanth.srmist@gmail.com");
	        person.setId(1L);
	        person.setName("Prasanth");
	        List<Person> personList = new ArrayList<>();
	        personList.add(person);

	        // providing knowledge
	        when(personRepository.findAll()).thenReturn(personList);

	        List<Person> fetchedPersons = personService.fetchAllPerson();
	        assertThat(fetchedPersons.size()).isGreaterThan(0);
	    }
	 
	 
	 

}
