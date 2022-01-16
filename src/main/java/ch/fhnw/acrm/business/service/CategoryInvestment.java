/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ch.fhnw.acrm.data.domain.CategoryInvestment;
import ch.fhnw.acrm.data.repository.CategoryInvestmentRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class CategoryInvestmentService {

	@Autowired
	private CategoryInvestmentRepository categoryInvestmentRepository;

	public CategoryInvestment findCategoryInvestmentById(Long categoryInvestmentId) throws Exception {
		List<CategoryInvestment> categoryList = categoryRepository.findByIdId(categoryInvestmentId);
		if(categoryList.isEmpty()){
			throw new Exception("No categoryinvestment with ID "+ categoryInvestmentId +" found.");
		}
		return categoryList.get(0);
	}

	public List<Category> findAllCategories() {
		return categoryRepository.findByAgentId(agentService.getCurrentAgent().getId());
	}
	
}
