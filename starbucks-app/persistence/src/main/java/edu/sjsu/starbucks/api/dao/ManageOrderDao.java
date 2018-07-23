package edu.sjsu.starbucks.api.dao;

import edu.sjsu.starbucks.model.Order;

public interface ManageOrderDao {

	public void saveOrder(Order order);

	public Order getOrderByOrderId(String orderId);
}
