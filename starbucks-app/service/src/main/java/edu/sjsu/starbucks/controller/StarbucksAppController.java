package edu.sjsu.starbucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.service.IManageOrderService;

@RestController
public class StarbucksAppController {
	
	@Autowired
	IManageOrderService manageOrderService;

	@GetMapping("/order")
	public OrderResponse getOrderByOrderId(String orderId) {
		return manageOrderService.getOrderByOrderId(orderId);
	}
	
	@PostMapping("/order")
	@ResponseBody
	public OrderResponse createOrder(@RequestBody CreateOrderRequest orderRequest) {
		return manageOrderService.createOrder(orderRequest);
	}
}
