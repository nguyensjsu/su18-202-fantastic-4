package edu.sjsu.starbucks.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.starbucks.api.dao.ManageOrderDao;
import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.service.Drinks;
import edu.sjsu.starbucks.api.service.IManageOrderService;
import edu.sjsu.starbucks.model.Order;
import edu.sjsu.starbucks.model.common.CoffeeType;
import edu.sjsu.starbucks.model.common.OrderStatus;

@Service
public class ManageOrderServiceImpl implements IManageOrderService {

	@Autowired
	private ManageOrderDao manageOrderDao;

	@Override
	public OrderResponse getOrderByOrderId(String orderId) {
		Order order = manageOrderDao.getOrderByOrderId(orderId);
		
		List<Drinks> coffee = getDrinks(order.getCoffee());
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderId);
		orderResponse.setCoffee(coffee);
		orderResponse.setStatus(order.getStatus());
		orderResponse.setTotalAmount(order.getTotalAmount());
		return orderResponse;
	}

	@Override
	public OrderResponse createOrder(CreateOrderRequest orderRequest) {
		Order order = new Order();
		order.setId(generateId());
		order.setUserName(orderRequest.getUserName());
		order.setCoffee(orderRequest.getCoffee());
		order.setStatus(OrderStatus.CREATED);

		manageOrderDao.saveOrder(order);

		List<Drinks> coffee = getDrinks(order.getCoffee());
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setCoffee(coffee);
		orderResponse.setOrderId(order.getId());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setTotalAmount(order.getTotalAmount());
		return orderResponse;
	}

	@Override
	public List<Drinks> getDrinks(List<CoffeeType> coffee) {
		List<Drinks> drinks = new ArrayList<>();
		for (CoffeeType type : coffee) {
			switch (type) {

			case LATTE:
				drinks.add(new Latte());
				break;

			case CAPPUCCINO:
				drinks.add(new Cappuccino());
				break;
				
			case ESPRESSO:
				drinks.add(new Espresso());
				break;
				
			default:
				break;
			}
		}
		return drinks;
	}

	private String generateId() {
		Long id = System.currentTimeMillis();
		StringBuffer generatedId = new StringBuffer();
		generatedId.append(id);
		generatedId.append(ThreadLocalRandom.current().nextInt(1, 100));
		return generatedId.toString();
	}

}
