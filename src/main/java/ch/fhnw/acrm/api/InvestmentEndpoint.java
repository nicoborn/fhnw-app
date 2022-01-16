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
import ch.fhnw.acrm.business.service.InvestmentService;
import ch.fhnw.acrm.data.domain.Investment;

import javax.validation.ConstraintViolationException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvestmentEndpoint {
    @Autowired
    private InvestmentService investmentService;

    @PostMapping(path = "/investment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Investment> postInvestment(@RequestBody Investment investment) {
        try {
            investment = investmentService.editInvestment(investment);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{investmentId}")
                .buildAndExpand(investment.getId()).toUri();

        return ResponseEntity.created(location).body(investment);
    }

    @GetMapping(path = "/investment", produces = "application/json")
    public List<Investment> getInvestment() {
        return investmentService.findAllInvestments();
    }

    @GetMapping(path = "/investment/{investmentId}", produces = "application/json")
    public ResponseEntity<Investment> getInvestment(@PathVariable(value = "investmentId") String investmentId) {
        Investment investment = null;
        try {
            investment = investmentService.findInvestmentById(Long.parseLong(investmentId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return ResponseEntity.ok(investment);
    }

    @PutMapping(path = "/investment/{investmentId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Investment> putInvestment(@RequestBody Investment investment, @PathVariable(value = "investmentId") String investmentId) {
        try {
            investment.setId(Long.parseLong(investmentId));
            investment = investmentService.editInvestment(investment);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().body(investment);
    }

    @DeleteMapping(path = "/investment/{investmentId}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable(value = "investmentId") String investmentId) {
        try {
            investmentService.deleteInvestment(Long.parseLong(investmentId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }
}