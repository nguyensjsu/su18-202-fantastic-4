package edu.sjsu.starbucks.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import edu.sjsu.starbucks.api.dao.OrderDao;
import edu.sjsu.starbucks.api.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void saveOrder(Order order) {
		mongoTemplate.save(order);
	}

}
