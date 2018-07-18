package edu.sjsu.starbucks.api.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.starbucks.api.dao.OrderDao;
import edu.sjsu.starbucks.api.entity.Order;
import edu.sjsu.starbucks.api.service.IStarbucksService;
import edu.sjsu.starbucks.model.request.OrderRequest;
import edu.sjsu.starbucks.model.response.OrderResponse;

@Service
public class StarbucksServiceImpl implements IStarbucksService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public OrderResponse getOrderByOrderId(String orderId) {
		//TODO: fetch order by database
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCost(10.0);
		orderResponse.setOrderId(orderId);
		return orderResponse;
	}

	@Override
	public OrderResponse createOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setId(generateId());
		order.setUserName(orderRequest.getUserName());
		order.setCoffee(orderRequest.getCoffee());
		order.setCost(10.0); //TODO: use payment API
		
		orderDao.saveOrder(order);
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCoffee(order.getCoffee());
		orderResponse.setOrderId(order.getId());
		orderResponse.setCost(order.getCost());
		return orderResponse;
	}

	private String generateId() {
		Long id = System.currentTimeMillis();
		StringBuffer generatedId = new StringBuffer();
		generatedId.append(id);
		generatedId.append(ThreadLocalRandom.current().nextInt(1, 100));
		return generatedId.toString();
	}

}
