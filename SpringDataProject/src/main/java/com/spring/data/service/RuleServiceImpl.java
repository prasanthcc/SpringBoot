package com.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.domain.Rule;
import com.spring.data.respository.RuleRepository;

@Service
public class RuleServiceImpl implements RuleService{

	
	@Autowired
	private RuleRepository repository;
	
	@Override
	public boolean saveRule(Rule r) {
			
		repository.save(r);
		
		return true;
	
	}

	@Override
	public List<Rule> fetchAllRules() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	public RuleRepository getRepository() {
		return repository;
	}

	public void setRepository(RuleRepository repository) {
		this.repository = repository;
	}
	
	
}
