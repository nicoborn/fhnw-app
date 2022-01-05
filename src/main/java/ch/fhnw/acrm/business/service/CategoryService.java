/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ch.fhnw.acrm.data.domain.Agent;
import ch.fhnw.acrm.data.domain.Category;
import ch.fhnw.acrm.data.repository.CategoryRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Service
@Validated
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    Validator validator;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void editCategory(@Valid Category category) throws Exception {
        
        categoryRepository.save(category);
    }

    public List<Category> findAllCategoriesByAgent() {
		return categoryRepository.findByAgentId(agentService.getCurrentAgent().getId());
	}

    public void deleteCategory(Long categoryId)
	{
		categoryRepository.deleteById(categoryId);
	}

}
