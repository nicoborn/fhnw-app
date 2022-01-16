package ch.fhnw.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

import java.time.*;

@Entity
public class Investment {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Double amount;
	private Double buyprice;
	private String symbol;
	@Column(columnDefinition = "DATE")
	private LocalDate investmentDate;
    @ManyToOne
	@JsonIgnore
	private Agent agent;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(Double buyprice) {
		this.buyprice = buyprice;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public LocalDate getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(LocalDate investmentDate) {
		this.investmentDate = investmentDate;
	}

    public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}
