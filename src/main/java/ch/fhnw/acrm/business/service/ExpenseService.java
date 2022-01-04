/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import ch.fhnw.acrm.data.domain.Expense;
import ch.fhnw.acrm.data.repository.ExpenseRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private AgentService agentService;

	public Expense editExpense(@Valid Expense expense) throws Exception {
		if (expense.getId() != null) {
			return expense;
		}
		
		return null;
	}

	public void deleteExpense(Long expenseId)
	{
		expenseRepository.deleteById(expenseId);
	}
	
	public Expense findExpenseById(Long expenseId) throws Exception {
		List<Expense> expenseList = expenseRepository.findByIdAndAgentId(expenseId, agentService.getCurrentAgent().getId());
		if(expenseList.isEmpty()){
			throw new Exception("No expense with ID "+ expenseId +" found.");
		}
		return expenseList.get(0);
	}

	public List<Expense> findAllExpenses() {
		return expenseRepository.findByAgentId(agentService.getCurrentAgent().getId());
	}
	
}
