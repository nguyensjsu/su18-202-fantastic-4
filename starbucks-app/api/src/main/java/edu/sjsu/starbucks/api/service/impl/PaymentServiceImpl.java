package edu.sjsu.starbucks.api.service.impl;

import java.util.List;

import javax.activity.InvalidActivityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import edu.sjsu.starbucks.api.dao.AddCardDao;
import edu.sjsu.starbucks.api.dao.ManageOrderDao;
import edu.sjsu.starbucks.api.response.CardResponse;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.response.PaymentResponse;
import edu.sjsu.starbucks.api.service.Drinks;
import edu.sjsu.starbucks.api.service.IManageOrderService;
import edu.sjsu.starbucks.api.service.IPaymentService;
import edu.sjsu.starbucks.model.Card;
import edu.sjsu.starbucks.model.Order;
import edu.sjsu.starbucks.model.common.CardStatus;
import edu.sjsu.starbucks.model.common.OrderStatus;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private ManageOrderDao manageOrderDao;

	@Autowired
	private AddCardDao addcardDao;

	@Autowired
	private IManageOrderService manageOrderService;

	@Override
	public OrderResponse calculateOrderAmount(String orderId) {
		Order order = manageOrderDao.getOrderByOrderId(orderId);
		List<Drinks> coffee = manageOrderService.getDrinks(order.getCoffee());

		Double totalAmount = 0.0;
		for (Drinks drink : coffee) {
			totalAmount += drink.getPrice();
		}

		order.setTotalAmount(totalAmount);
		manageOrderDao.saveOrder(order);

		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orderId);
		orderResponse.setCoffee(coffee);
		orderResponse.setStatus(order.getStatus());
		orderResponse.setTotalAmount(order.getTotalAmount());
		return orderResponse;
	}

	@Override
	public PaymentResponse makePayment(String orderId) throws InvalidActivityException {
		PaymentResponse response = new PaymentResponse();
		Order order = manageOrderDao.getOrderByOrderId(orderId);

		List<Card> cards = addcardDao.getCards(order.getUserName());

		if (CollectionUtils.isEmpty(cards)) {
			throw new InvalidActivityException("No Credit Card available");
		}
		for (Card dbCard : cards) {
			if (CardStatus.ACTIVE.equals(dbCard.getStatus())) {
				double balance = dbCard.getBalance() - order.getTotalAmount();
				if(balance < 0) {
					throw new InvalidActivityException("Insufficient Card Balance");
				}
				order.setStatus(OrderStatus.PAID);
				dbCard.setBalance(balance);
				manageOrderDao.saveOrder(order);
				addcardDao.addCard(dbCard);
				
				CardResponse cardResponse = new CardResponse();
				cardResponse.setCardNumber(dbCard.getCardNumber());
				cardResponse.setBalance(dbCard.getBalance());
				cardResponse.setStatus(dbCard.getStatus());
				
				List<Drinks> coffee = manageOrderService.getDrinks(order.getCoffee());
				response.setCoffee(coffee);
				
				response.setOrderId(orderId);
				response.setStatus(order.getStatus());
				response.setTotalAmount(order.getTotalAmount());
				response.setCard(cardResponse);
			}
		}
		// TODO fetch the order by order id
		// if total = 0 throw error
		// if not 0, get the card details, subtract total from card amount if bal is not
		// negative then set the card amount to new value and
		// update order status to delivered

		return response;
	}

}
