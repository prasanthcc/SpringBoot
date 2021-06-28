package com.spring.data.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class,
 property = "id")
public class Rule {
		
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column  
 private String ruleName;
 
 @JsonSerialize
 @ManyToMany(mappedBy = "rules")
 private List<Person> persons;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getRuleName() {
	return ruleName;
}


public void setRuleName(String ruleName) {
	this.ruleName = ruleName;
}


public List<Person> getPersons() {
	return persons;
}


public void setPersons(List<Person> persons) {
	this.persons = persons;
}  
 
 


}