package com.spring.data;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.data.domain.Person;
import com.spring.data.domain.Rule;
import com.spring.data.service.PersonService;
import com.spring.data.service.RuleService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@MockBean
	private RuleService ruleService;

	@Test
	public void save_person_success() throws Exception {
			Person person = new Person();
	        person.setEmailId("prasanth.srmist@gmail.com");
	        person.setId(1L);
	        person.setName("Prasanth");
	        when(personService.savePerson(any())).thenReturn(Boolean.TRUE);
	        
	        mockMvc.perform(
	                MockMvcRequestBuilders.post("/data/save/person")
	                        .content(asJsonString(person))
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .accept(MediaType.APPLICATION_JSON)
	        )
	                .andExpect(status().isOk())
	                .andExpect(content().string("Person Save/update Done"));
	}
	
	@Test
	public void save_rule_success() throws Exception {
			Rule rule = new Rule();
	        rule.setId(1L);
	        rule.setRuleName("Rule Name1");
	        when(ruleService.saveRule(any())).thenReturn(Boolean.TRUE);
	        
	        mockMvc.perform(
	                MockMvcRequestBuilders.post("/data/save/rule")
	                        .content(asJsonString(rule))
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .accept(MediaType.APPLICATION_JSON)
	        )
	                .andExpect(status().isOk())
	                .andExpect(content().string("Rule Save/update Done"));
	}
	
	
	
	
	  public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	  
	  

}
