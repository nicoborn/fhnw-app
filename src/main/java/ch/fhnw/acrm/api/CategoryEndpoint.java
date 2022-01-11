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
import ch.fhnw.acrm.business.service.CategoryService;
import ch.fhnw.acrm.data.domain.Category;

import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CategoryEndpoint {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/category", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> postCategory(@RequestBody Category category) {
        try {
            category = categoryService.editCategory(category);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{categoryId}")
                .buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(location).body(category);
    }

    @GetMapping(path = "/category", produces = "application/json")
    public List<Category> getCategory() {
        return categoryService.findAllCategories();
    }

    @GetMapping(path = "/category/{categoryId}", produces = "application/json")
    public ResponseEntity<Category> getCategory(@PathVariable(value = "categoryId") String categoryId) {
        Category category = null;
        try {
            category = categoryService.findCategoryById(Long.parseLong(categoryId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return ResponseEntity.ok(category);
    }

    @PutMapping(path = "/category/{categoryId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> putCategory(@RequestBody Category category, @PathVariable(value = "categoryId") String categoryId) {
        try {
            category.setId(Long.parseLong(categoryId));
            category = categoryService.editCategory(category);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().body(category);
    }

    @DeleteMapping(path = "/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(value = "categoryId") String categoryId) {
        try {
            categoryService.deleteCategory(Long.parseLong(categoryId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }
}