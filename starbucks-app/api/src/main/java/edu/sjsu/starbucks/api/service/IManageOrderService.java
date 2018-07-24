package edu.sjsu.starbucks.api.service;

import java.util.List;

import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.request.UpdateOrderRequest;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.model.common.CoffeeType;

/**
 * Business Logic for Managing Orders
 * @author Anushri Srinath Aithal
 *
 */
public interface IManageOrderService {

	/**
	 * Get Orders By Order Id
	 * @param orderId
	 * @return
	 */
	public OrderResponse getOrderByOrderId(String orderId);

	/**
	 * Create an Order
	 * @param orderRequest
	 * @return
	 */
	public OrderResponse createOrder(CreateOrderRequest orderRequest);

	/**
	 * Get Price and Description of each COffee Type
	 * @param coffee
	 * @return
	 */
	public List<Drinks> getDrinks(List<CoffeeType> coffee);

	public OrderResponse updateOrderStatus(UpdateOrderRequest orderRequest);

}
