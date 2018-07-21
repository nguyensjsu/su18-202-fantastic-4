package edu.sjsu.starbucks.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

}
