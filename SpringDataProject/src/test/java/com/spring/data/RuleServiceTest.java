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

import com.spring.data.domain.Rule;
import com.spring.data.respository.RuleRepository;
import com.spring.data.service.RuleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RuleServiceTest {
	
	@Mock
    private RuleRepository ruleRepository;
	
	
    private RuleServiceImpl ruleService;
	
	  @BeforeEach
	    void initUseCase() {
		  ruleService = new RuleServiceImpl();
		  ruleService.setRepository(ruleRepository);
	    }
	  
	 @Test
	    public void savedPerson_Success() {
	        Rule rule = new Rule();
	        rule.setId(1L);
	        rule.setRuleName("Rule Name1");
	        when(ruleRepository.save(rule)).thenReturn(rule);
	        Rule savedRule = ruleRepository.save(rule);
	        assertThat(savedRule.getRuleName()).isNotNull();
	        assertThat(savedRule.getRuleName()).isNotEqualTo("Prasanth");

	    }
	 
	 
	 @Test
	    public void rule_exists_in_db_success() {
	        Rule rule = new Rule();
	        rule.setId(1L);
	        rule.setRuleName("Rule Name1");
	        List<Rule> ruleList = new ArrayList<>();
	        ruleList.add(rule);
	        when(ruleRepository.findAll()).thenReturn(ruleList);
        
	        List<Rule> fetchedCustomers = ruleService.fetchAllRules();
	        assertThat(fetchedCustomers.size()).isGreaterThan(0);
	    }
	 
	 

}
