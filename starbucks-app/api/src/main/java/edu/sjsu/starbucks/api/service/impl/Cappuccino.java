package edu.sjsu.starbucks.api.service.impl;

import edu.sjsu.starbucks.api.service.Drinks;

public class Cappuccino implements Drinks {

	private Double price = 7.99;
	
	@Override
	public String getDescription() {
		return "Cappuccino";
	}

	@Override
	public Double getPrice() {
		return price;
	}

}
