package com.spring.data.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	

}
