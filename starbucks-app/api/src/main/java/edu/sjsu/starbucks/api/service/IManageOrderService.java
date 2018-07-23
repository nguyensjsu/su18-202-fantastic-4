package edu.sjsu.starbucks.api.service;

import java.util.List;

import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.model.common.CoffeeType;

public interface IManageOrderService {

	public OrderResponse getOrderByOrderId(String orderId);

	public OrderResponse createOrder(CreateOrderRequest orderRequest);

	public List<Drinks> getDrinks(List<CoffeeType> coffee);

}
