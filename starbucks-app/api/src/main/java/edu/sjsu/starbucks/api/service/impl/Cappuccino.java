package edu.sjsu.starbucks.api.service.impl;

import edu.sjsu.starbucks.api.service.Drinks;

/**
 * Concrete Decorator
 *  @author Anushri Srinath Aithal
 *
 */
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
