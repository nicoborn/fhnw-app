
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
    public String getCustomerCreateView(){
        return "../expense/expenseCreate.html";
    }

}

