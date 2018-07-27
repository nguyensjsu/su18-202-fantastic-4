package edu.sjsu.starbucks.api.response;

import java.io.Serializable;
import java.util.List;

import edu.sjsu.starbucks.api.service.Drinks;
import edu.sjsu.starbucks.model.common.OrderStatus;

public class PaymentResponse implements Serializable {

	private static final long serialVersionUID = 1463056191931983541L;
	private String orderId;
	private List<Drinks> coffee;
	private Double totalAmount;
	private OrderStatus status;
	private CardResponse card;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Drinks> getCoffee() {
		return coffee;
	}

	public void setCoffee(List<Drinks> coffee) {
		this.coffee = coffee;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public CardResponse getCard() {
		return card;
	}

	public void setCard(CardResponse card) {
		this.card = card;
	}
}
