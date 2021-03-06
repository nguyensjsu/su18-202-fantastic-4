package edu.sjsu.starbucks.controller;

import javax.activity.InvalidActivityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.starbucks.api.request.AddCardRequest;
import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.request.CreateUserRequest;
import edu.sjsu.starbucks.api.request.ReloadCardRequest;
import edu.sjsu.starbucks.api.request.UpdateOrderRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.response.PaymentResponse;
import edu.sjsu.starbucks.api.response.UserResponse;
import edu.sjsu.starbucks.api.service.IAddCardService;
import edu.sjsu.starbucks.api.service.IManageOrderService;
import edu.sjsu.starbucks.api.service.IPaymentService;
import edu.sjsu.starbucks.api.service.IUserService;

@RestController
public class StarbucksAppController {

	@Autowired
	private IManageOrderService manageOrderService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAddCardService addcardservice;
	
	@Autowired
	private IPaymentService paymentService;

	/**
	 * API to Retrieve Order
	 * 
	 * @author Anushri Srinath Aithal
	 * @param orderId
	 * @return
	 */

	@GetMapping("/order")
	public OrderResponse getOrderByOrderId(String orderId) {
		return manageOrderService.getOrderByOrderId(orderId);
	}

	/**
	 * API to create Orders
	 * 
	 * @author Anushri Srinath Aithal
	 * @param orderRequest
	 * @return
	 */
	@PostMapping("/order")
	@ResponseBody
	public OrderResponse createOrder(@RequestBody CreateOrderRequest orderRequest) {
		return manageOrderService.createOrder(orderRequest);
	}

	/**
	 * API to update order status
	 * 
	 * @author Anushri Srinath Aithal
	 * @param orderRequest
	 * @return
	 */
	@PutMapping("/order")
	@ResponseBody
	public OrderResponse updateOrderStatus(@RequestBody UpdateOrderRequest orderRequest) {
		return manageOrderService.updateOrderStatus(orderRequest);
	}

	/**
	 * Saloni
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/user")
	@ResponseBody
	public UserResponse createUser(@RequestBody CreateUserRequest request) {
		return userService.createUser(request);
	}

	@GetMapping("/user")
	public UserResponse getUserByEmail(String userName) {
		return userService.getUserByEmail(userName);
	}

	/**
	 * Anu Sebastian
	 *
	 * @param addcardrequest
	 * @return
	 * @throws IllegalAccessException 
	 */
	@PostMapping("/card")
	@ResponseBody
	public CardDetailsResponse AddCard(@RequestBody AddCardRequest addcardrequest) throws IllegalAccessException {
		return addcardservice.addCard(addcardrequest);
	}

	@GetMapping("/card")
	public CardDetailsResponse GetCards(String userName) {
		return addcardservice.getCards(userName);
	}

	/**
	 * Anu Sebastian
	 *
	 * @param reloadcardrequest
	 * @return
	 */

	@PutMapping ("/reloadbalance")
	@ResponseBody
	public CardDetailsResponse reloadCard(@RequestBody ReloadCardRequest reloadcardrequest){
		return addcardservice.reloadCard(reloadcardrequest);
	}
	
	@GetMapping("/payment")
	public OrderResponse calculateCost(String orderId) {
		return paymentService.calculateOrderAmount(orderId);
	}
	
	@PostMapping("/payment")
	@ResponseBody
	public PaymentResponse makePayment(@RequestBody String orderId) throws InvalidActivityException {
		return paymentService.makePayment(orderId);
	}
}
