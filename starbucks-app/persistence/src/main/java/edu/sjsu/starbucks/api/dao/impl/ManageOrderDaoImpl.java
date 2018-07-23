package edu.sjsu.starbucks.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.starbucks.api.dao.ManageOrderDao;
import edu.sjsu.starbucks.model.Order;

@Repository
public class ManageOrderDaoImpl implements ManageOrderDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void saveOrder(Order order) {
		mongoTemplate.save(order);
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		Criteria criteria = Criteria.where("").is(orderId);
		Query query = new Query(criteria);
		Order order = mongoTemplate.findOne(query, Order.class);
		return order;
	}
}
