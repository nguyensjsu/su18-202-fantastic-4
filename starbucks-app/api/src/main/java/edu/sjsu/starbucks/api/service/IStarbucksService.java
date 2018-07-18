package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.model.response.OrderResponse;

public interface IStarbucksService {

	public OrderResponse getOrderByOrderId(String orderId);

}
