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
import ch.fhnw.acrm.business.service.ExpenseService;
import ch.fhnw.acrm.data.domain.Expense;

import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ExpenseEndpoint {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping(path = "/expense", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Expense> postExpense(@RequestBody Expense expense) {
        try {
            expense = expenseService.editExpense(expense);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{expenseId}")
                .buildAndExpand(expense.getId()).toUri();

        return ResponseEntity.created(location).body(expense);
    }

    @GetMapping(path = "/expense", produces = "application/json")
    public List<Expense> getExpense() {
        return expenseService.findAllExpenses();
    }

    @GetMapping(path = "/expense/{expenseId}", produces = "application/json")
    public ResponseEntity<Expense> getExpense(@PathVariable(value = "expenseId") String expenseId) {
        Expense expense = null;
        try {
            expense = expenseService.findExpenseById(Long.parseLong(expenseId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return ResponseEntity.ok(expense);
    }

    @PutMapping(path = "/expense/{expenseId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Expense> putExpense(@RequestBody Expense expense, @PathVariable(value = "expenseId") String expenseId) {
        try {
            expense.setId(Long.parseLong(expenseId));
            expense = expenseService.editExpense(expense);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().body(expense);
    }

    @DeleteMapping(path = "/expense/{expenseId}")
    public ResponseEntity<Void> deleteExpense(@PathVariable(value = "expenseId") String expenseId) {
        try {
            expenseService.deleteCustomer(Long.parseLong(expenseId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }
}