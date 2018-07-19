package edu.sjsu.starbucks.api.response;

import java.io.Serializable;
import java.util.List;

import edu.sjsu.starbucks.model.common.CoffeeType;

public class OrderResponse implements Serializable {

	private static final long serialVersionUID = 5947430519691865305L;
	private String orderId;
	private List<CoffeeType> coffee;
	private Double cost;
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
	
}
