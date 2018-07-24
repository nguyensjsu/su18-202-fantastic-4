package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.api.response.OrderResponse;

public interface IPaymentService {
	
	public OrderResponse calculateOrderAmount(String orderId);
	
	public OrderResponse makePayment(String orderId);

}
