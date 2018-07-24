package edu.sjsu.starbucks.api.service.impl;

import edu.sjsu.starbucks.api.service.Drinks;

/**
 * Concrete Decorator
 *  @author Anushri Srinath Aithal
 *
 */
public class Latte implements Drinks {
	
	private Double price = 5.99;

	@Override
	public String getDescription() {
		return "Latte";
	}

	@Override
	public Double getPrice() {
		return price;
	}

}
