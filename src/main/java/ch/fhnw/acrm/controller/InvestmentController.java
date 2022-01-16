/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/investment")
public class InvestmentController {

    @GetMapping
    public String getInvestmentView(){
        return "investment/investment.html";
    }

    @GetMapping("/create")
    public String getInvestmentCreateView(){
        return "../investment/investmentCreate.html";
    }

    @GetMapping("/edit")
    public String getInvestmentEditView(){
        return "../investment/investmentEdit.html";
    }
}
