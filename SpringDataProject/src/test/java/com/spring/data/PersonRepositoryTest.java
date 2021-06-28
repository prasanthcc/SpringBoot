package com.spring.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.data.domain.Person;
import com.spring.data.respository.PersonRepository;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class PersonRepositoryTest {
	
	@Autowired
	PersonRepository repo;
	
	@BeforeEach
    void initUseCase() {
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setEmailId("prasanth.srmist@gmail.com");
        person.setName("Prasanth");
        persons.add(person);
        repo.saveAll(persons);
    }
	
	 @AfterEach
	    public void destroyAll(){
		 repo.deleteAll();
	  }
	 
	
	 @Test
	    void saveAll_success() {
		  List<Person> persons = new ArrayList<>();
	        Person person = new Person();
	        person.setEmailId("prasanth.srmist@gmail.com");
	        person.setName("Prasanth");
	        persons.add(person);
	        
	        Iterable<Person> allPerson = repo.saveAll(persons);

	        AtomicInteger validIdFound = new AtomicInteger();
	        allPerson.forEach(person1 -> {
	            if(person1.getId()>0){
	                validIdFound.getAndIncrement();
	            }
	        });

	        assertThat(validIdFound.intValue()).isEqualTo(1);
	    }
	
	
	
	 
	 @Test
	 void findAll_success() {
	     List<Person> allPerson = repo.findAll();
	     assertThat(allPerson.size()).isGreaterThanOrEqualTo(1);
	 }
}
