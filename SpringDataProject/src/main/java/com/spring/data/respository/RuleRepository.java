package com.spring.data.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.domain.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer> {

}
