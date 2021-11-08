/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/expense")
public class ExpenseController {

    @GetMapping
    public String getExpenseView(){
        return "expense/expense.html";
    }

    @GetMapping("/create")
    public String getExpenseCreateView(){
        return "../expense/expenseCreate.html";
    }

    @GetMapping("/edit")
    public String getExpenseEditView(){
        return "../acrm/expenseEdit.html";
    }
}
