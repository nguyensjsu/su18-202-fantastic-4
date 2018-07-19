package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.api.request.OrderRequest;
import edu.sjsu.starbucks.api.response.OrderResponse;

public interface IStarbucksService {

	public OrderResponse getOrderByOrderId(String orderId);

	public OrderResponse createOrder(OrderRequest orderRequest);

}
