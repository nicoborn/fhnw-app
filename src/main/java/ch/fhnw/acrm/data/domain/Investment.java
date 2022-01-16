package ch.fhnw.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.*;

@Entity
public class Investment {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Column(columnDefinition = "DATE")
	private LocalDate investmentDate;
    @ManyToOne
	@JsonIgnore
	private Agent agent;
	@ManyToOne
	private CategoryInvestment categoryinvestment;


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

	public CategoryInvestment getCategoryInvestment() {
		return categoryinvestment;
	}

	public void setCategoryInvestment(CategoryInvestment categoryinvestment) {
		this.categoryinvestment = categoryinvestment;
	}

}
