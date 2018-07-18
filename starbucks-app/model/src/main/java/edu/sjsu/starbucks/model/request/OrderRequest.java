package edu.sjsu.starbucks.model.request;

import java.io.Serializable;

public class OrderRequest implements Serializable {

	private static final long serialVersionUID = -5976800150726340250L;
	private String orderId;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
