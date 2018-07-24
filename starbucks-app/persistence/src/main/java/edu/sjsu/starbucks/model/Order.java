package edu.sjsu.starbucks.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.sjsu.starbucks.model.common.CoffeeType;
import edu.sjsu.starbucks.model.common.OrderStatus;

@Document(collection = "order")
public class Order {

	@Id
	private String id;
	private String userName;
	private List<CoffeeType> coffee;
	private Double totalAmount;
	private OrderStatus status;

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
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
