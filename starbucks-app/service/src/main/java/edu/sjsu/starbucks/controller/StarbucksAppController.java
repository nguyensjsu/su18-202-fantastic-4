package edu.sjsu.starbucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.starbucks.api.service.IStarbucksService;
import edu.sjsu.starbucks.model.response.OrderResponse;

@RestController
public class StarbucksAppController {
	
	@Autowired
	IStarbucksService service;

	@GetMapping("/order")
	public OrderResponse getOrderByOrderId(String orderId) {
		return service.getOrderByOrderId(orderId);
	}
}
