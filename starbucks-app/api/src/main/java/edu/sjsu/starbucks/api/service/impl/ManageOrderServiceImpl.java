package edu.sjsu.starbucks.api.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.starbucks.api.dao.ManageOrderDao;
import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.service.IManageOrderService;
import edu.sjsu.starbucks.model.Order;

@Service
public class ManageOrderServiceImpl implements IManageOrderService {

	@Autowired
	private ManageOrderDao manageOrderDao;
	
	@Override
	public OrderResponse getOrderByOrderId(String orderId) {
		//TODO: fetch order by database
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCost(10.0);
		orderResponse.setOrderId(orderId);
		return orderResponse;
	}

	@Override
	public OrderResponse createOrder(CreateOrderRequest orderRequest) {
		Order order = new Order();
		order.setId(generateId());
		order.setUserName(orderRequest.getUserName());
		order.setCoffee(orderRequest.getCoffee());
		order.setCost(10.0); //TODO: use payment API
		
		manageOrderDao.saveOrder(order);
		
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
