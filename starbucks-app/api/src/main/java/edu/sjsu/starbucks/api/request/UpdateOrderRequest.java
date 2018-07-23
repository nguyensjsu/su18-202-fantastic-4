package edu.sjsu.starbucks.api.request;

import java.io.Serializable;

import edu.sjsu.starbucks.model.common.OrderStatus;

/**
 * Request for Updating Order Status
 * @author Anushri Srinath Aithal
 *
 */
public class UpdateOrderRequest implements Serializable {

	private static final long serialVersionUID = 8534528305321740651L;
	private String orderId;
	private OrderStatus status;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
