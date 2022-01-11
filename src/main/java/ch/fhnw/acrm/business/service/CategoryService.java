/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ch.fhnw.acrm.data.domain.Category;
import ch.fhnw.acrm.data.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AgentService agentService;
	
	public Category editCategory(@Valid Category category) throws Exception {
		if (category.getId() == null) {
			// New category
			if (categoryRepository.findByName(category.getName()) == null) {
				category.setAgent(agentService.getCurrentAgent());
				return categoryRepository.save(category);
			}
			throw new Exception("Mobile number " + category.getName() + " already assigned to an expense.");
		} else {
			// Edit category
			if (category.getAgent() == null) {
				category.setAgent(agentService.getCurrentAgent());
			}
			return categoryRepository.save(category);
		}
	}

	public void deleteCategory(Long categoryId)
	{
		categoryRepository.deleteById(categoryId);
	}
	
	public Category findCategoryById(Long categoryId) throws Exception {
		List<Category> categoryList = categoryRepository.findByIdAndAgentId(categoryId, agentService.getCurrentAgent().getId());
		if(categoryList.isEmpty()){
			throw new Exception("No category with ID "+ categoryId +" found.");
		}
		return categoryList.get(0);
	}

	public List<Category> findAllCategories() {
		return categoryRepository.findByAgentId(agentService.getCurrentAgent().getId());
	}
	
}
