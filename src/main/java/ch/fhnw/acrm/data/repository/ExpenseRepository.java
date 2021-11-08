/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.data.repository;

import ch.fhnw.acrm.data.domain.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	Expense findByName(String mobile);
	Expense findByDescription(String description);
	List<Expense> findByAgentId(Long agentId);
	List<Expense> findByIdAndAgentId(Long expenseId, Long agentId);
}