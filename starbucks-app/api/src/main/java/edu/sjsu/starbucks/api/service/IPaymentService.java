package edu.sjsu.starbucks.api.service;

import javax.activity.InvalidActivityException;

import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.response.PaymentResponse;

public interface IPaymentService {
	
	public OrderResponse calculateOrderAmount(String orderId);
	
	public PaymentResponse makePayment(String orderId) throws InvalidActivityException;

}
