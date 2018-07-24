package edu.sjsu.starbucks.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.starbucks.api.dao.ManageOrderDao;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.service.Drinks;
import edu.sjsu.starbucks.api.service.IManageOrderService;
import edu.sjsu.starbucks.api.service.IPaymentService;
import edu.sjsu.starbucks.model.Order;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private ManageOrderDao manageOrderDao;
	
	@Autowired
	private IManageOrderService manageOrderService;
	
	@Override
	public OrderResponse calculateOrderAmount(String orderId) {
		Order order = manageOrderDao.getOrderByOrderId(orderId);
		List<Drinks> coffee = manageOrderService.getDrinks(order.getCoffee());
		
		Double totalAmount = 0.0;
		for(Drinks drink : coffee) {
			totalAmount += drink.getPrice();
		}
		
		order.setTotalAmount(totalAmount);
		manageOrderDao.saveOrder(order);
		
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderId);
		orderResponse.setCoffee(coffee);
		orderResponse.setStatus(order.getStatus());
		orderResponse.setTotalAmount(order.getTotalAmount());
		return orderResponse;
	}

	@Override
	public OrderResponse makePayment(String orderId) {
		// TODO fetch the order by order id
		// if total = 0 throw error
		// if not 0, get the card details, subtract total from card amount if bal is not negative then set the card amount to new value and
		//update order status to delivered 
		
		return null;
	}

}
