package edu.sjsu.starbucks.api.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.sjsu.starbucks.model.common.CoffeeType;

@Document(collection = "order")
public class Order {

	@Id
	private String id;
	private String userName;
	private List<CoffeeType> coffee;
	private Double cost;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CoffeeType> getCoffee() {
		return coffee;
	}

	public void setCoffee(List<CoffeeType> coffee) {
		this.coffee = coffee;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
