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

import com.spring.data.domain.Rule;
import com.spring.data.respository.RuleRepository;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class RulesRepositoryTest {

	@Autowired
	RuleRepository ruleRepository;



	@BeforeEach	
	void  initMethod(){
		Rule rule = new Rule();
		rule.setRuleName("Rule Name1");
		Rule rule1 = new Rule();
		rule1.setRuleName("Rule Name1");
		List<Rule> list = new ArrayList<>();
		List<Rule> unmodifiableList = List.of(rule,rule1);
		ruleRepository.saveAll(unmodifiableList);
	}

	@AfterEach
	public void destroyAll(){
		ruleRepository.deleteAll();
	}

	@Test
	void saveAll_success() {

		Rule rule = new Rule();
		rule.setId(1L);
		rule.setRuleName("Rule Name1");
		List<Rule> list = new ArrayList<>();
		list.add(rule);

		List<Rule> listSaved = List.copyOf(ruleRepository.saveAll(list));
		List.of(listSaved);
		AtomicInteger validIdFound = new AtomicInteger();

		listSaved.stream().forEach(rulesSaved -> {
			if(rulesSaved.getId() >= 1) {
				validIdFound.getAndIncrement();
			}
		});


		assertThat(validIdFound.intValue()).isEqualTo(1);
	}
	
	 @Test
	 void findAll_success() {
		 
		 List<Rule> listSaved = ruleRepository.findAll();
		 assertThat(listSaved.size()).isEqualTo(2);
		
	}
	



}
