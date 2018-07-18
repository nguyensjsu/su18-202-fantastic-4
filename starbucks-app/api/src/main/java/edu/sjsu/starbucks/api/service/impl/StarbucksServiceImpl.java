package edu.sjsu.starbucks.api.service.impl;

import org.springframework.stereotype.Service;

import edu.sjsu.starbucks.api.service.IStarbucksService;
import edu.sjsu.starbucks.model.response.OrderResponse;

@Service
public class StarbucksServiceImpl implements IStarbucksService {

	@Override
	public OrderResponse getOrderByOrderId(String orderId) {
		//TODO: fetch order by database
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCost(10.0);
		orderResponse.setOrderId(orderId);
		return orderResponse;
	}

}
