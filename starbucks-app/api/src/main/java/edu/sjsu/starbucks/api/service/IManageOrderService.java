package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.response.OrderResponse;

public interface IManageOrderService {

	public OrderResponse getOrderByOrderId(String orderId);

	public OrderResponse createOrder(CreateOrderRequest orderRequest);

}
