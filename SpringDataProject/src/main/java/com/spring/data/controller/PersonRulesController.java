package com.spring.data.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.domain.Person;
import com.spring.data.domain.Rule;
import com.spring.data.service.PersonService;
import com.spring.data.service.RuleService;

@RestController
@RequestMapping("/data")
public class PersonRulesController {
	
	
	@Autowired
	PersonService personService;
	
	@Autowired
	RuleService ruleService;
	
	@PostMapping("/save/person")
	public ResponseEntity<String> savePerson(@RequestBody Person person) {
		Boolean success = personService.savePerson(person);
		if(success) {
		return  new ResponseEntity<>("Person Save/update Done", HttpStatus.OK);
		}else {
            return new ResponseEntity<>("Person Save/update failed", HttpStatus.OK);
		}
	}
	
	
	@PostMapping("/save/rule")
	public ResponseEntity<String> saveRule(@RequestBody Rule rule) {
		Boolean success = ruleService.saveRule(rule);
		if(success) {
		return  new ResponseEntity<>("Rule Save/update Done", HttpStatus.OK);
		}else {
            return new ResponseEntity<>("Rule Save/update failed", HttpStatus.OK);
		}
	}
	
	
	  @GetMapping(value = "/fetchAllPerson")
	    public ResponseEntity<List<Person>> fetchAllPerson() throws RuntimeException {
	        return new ResponseEntity<>(List.copyOf(personService.fetchAllPerson()), HttpStatus.OK);
	    }
	  
	  @GetMapping(value = "/fetch/Person/{urlParameter}")
	    public Person fetchAlOnePerson(@PathVariable("urlParameter") String id)  {
	        
		  return personService.fetchPerson(Integer.parseInt(id));
	    }
	
	
	
	  @GetMapping(value = "/fetchAllRule")
	    public ResponseEntity<List<Rule>> fetchAllRule() throws RuntimeException {
		  List returnList = List.of(ruleService.fetchAllRules());
		  
	        return new ResponseEntity<>(returnList, HttpStatus.OK);
	    }

}
