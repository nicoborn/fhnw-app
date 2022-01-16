/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ch.fhnw.acrm.data.domain.Investment;
import ch.fhnw.acrm.data.repository.InvestmentRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class InvestmentService {

	@Autowired
	private InvestmentRepository investmentRepository;
	@Autowired
	private AgentService agentService;

	public Investment editInvestment(@Valid Investment investment) throws Exception {
		if (investment.getId() == null) {
			if (investmentRepository.findByName(investment.getName()) == null) {
				investment.setAgent(agentService.getCurrentAgent());
				return investmentRepository.save(investment);
			}
			throw new Exception("Mobile number " + investment.getName() + " already assigned to an expense.");
		} else {
			if (investment.getAgent() == null) {
				investment.setAgent(agentService.getCurrentAgent());
			}
			return investmentRepository.save(investment);
		}
	}

	public void deleteInvestment(Long investmentId)
	{
		investmentRepository.deleteById(investmentId);
	}
	
	public Investment findInvestmentById(Long investmentId) throws Exception {
		List<Investment> investmentList = investmentRepository.findByIdAndAgentId(investmentId, agentService.getCurrentAgent().getId());
		if(investmentList.isEmpty()){
			throw new Exception("No investment with ID "+ investmentId +" found.");
		}
		return investmentList.get(0);
	}

	public List<Investment> findAllInvestments() {
		return investmentRepository.findByAgentId(agentService.getCurrentAgent().getId());
	}
	
}
