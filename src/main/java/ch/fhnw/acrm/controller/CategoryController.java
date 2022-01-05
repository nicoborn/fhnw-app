/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @GetMapping
    public String getCategoryView(){
        return "category/category.html";
    }

    @GetMapping("/create")
    public String getCategoryCreateView(){
        return "../category/categoryCreate.html";
    }

    @GetMapping("/edit")
    public String getCategoryEditView(){
        return "../category/categoryEdit.html";
    }
}
