package edu.sjsu.starbucks.api.request;

import java.io.Serializable;
import java.util.List;

import edu.sjsu.starbucks.model.common.CoffeeType;

public class OrderRequest implements Serializable {

	private static final long serialVersionUID = -5976800150726340250L;
	private String userName;
	private List<CoffeeType> coffee;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<CoffeeType> getCoffee() {
		return coffee;
	}

	public void setCoffee(List<CoffeeType> coffee) {
		this.coffee = coffee;
	}

}
