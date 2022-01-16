/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ch.fhnw.acrm.business.service.CategoryInvestmentService;
import ch.fhnw.acrm.data.domain.CategoryInvestment;

import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CategoryInvestmentEndpoint {
    @Autowired
    private CategoryInvestmentService categoryInvestmentService;

    @GetMapping(path = "/categoryinvestment", produces = "application/json")
    public List<CategoryInvestment> getCategoryInvestment() {
        return categoryInvestmentService.findAllCategories();
    }

    @GetMapping(path = "/category/{categoryInvestmentId}", produces = "application/json")
    public ResponseEntity<CategoryInvestment> getCategoryInvestment(@PathVariable(value = "categoryInvestmentId") String categoryId) {
        CategoryInvestment category = null;
        try {
            category = categoryInvestmentService.findCategoryInvestmentById(Long.parseLong(categoryId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return ResponseEntity.ok(category);
    }

}