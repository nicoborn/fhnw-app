package ch.fhnw.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Option {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Int 
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
