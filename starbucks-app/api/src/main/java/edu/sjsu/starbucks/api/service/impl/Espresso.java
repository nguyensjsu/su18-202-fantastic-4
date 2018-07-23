package edu.sjsu.starbucks.api.service.impl;

import edu.sjsu.starbucks.api.service.Drinks;

public class Espresso implements Drinks {

	private Double price = 3.99;

	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public Double getPrice() {
		return price;
	}
	
}
