package com.spring.data.service;

import java.util.List;

import com.spring.data.domain.Rule;

public interface RuleService {
	
	public boolean saveRule(Rule r);
	public List<Rule> fetchAllRules();

}
