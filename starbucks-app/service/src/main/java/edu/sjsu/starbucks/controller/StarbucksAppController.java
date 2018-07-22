package edu.sjsu.starbucks.controller;

import edu.sjsu.starbucks.api.request.CreateUserRequest;
import edu.sjsu.starbucks.api.response.UserResponse;
import edu.sjsu.starbucks.api.service.IUserService;
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

	@Autowired
	IUserService userService;

	@GetMapping("/order")
	public OrderResponse getOrderByOrderId(String orderId) {
		return manageOrderService.getOrderByOrderId(orderId);
	}
	
	@PostMapping("/order")
	@ResponseBody
	public OrderResponse createOrder(@RequestBody CreateOrderRequest orderRequest) {
		return manageOrderService.createOrder(orderRequest);
	}

	/**
	 * Saloni
	 * @param request
	 * @return
	 */
	@PostMapping("/user")
	@ResponseBody
	public UserResponse createUser(@RequestBody  CreateUserRequest request) {
		return userService.createUser(request);
	}

	@GetMapping("/user")
	public UserResponse getUserByEmail(String userName) {
		return userService.getUserByEmail(userName);
	}
}
