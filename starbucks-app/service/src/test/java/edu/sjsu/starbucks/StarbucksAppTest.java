package edu.sjsu.starbucks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import edu.sjsu.starbucks.api.request.AddCardRequest;
import edu.sjsu.starbucks.api.request.CreateOrderRequest;
import edu.sjsu.starbucks.api.request.CreateUserRequest;
import edu.sjsu.starbucks.api.request.ReloadCardRequest;
import edu.sjsu.starbucks.api.response.CardDetailsResponse;
import edu.sjsu.starbucks.api.response.CardResponse;
import edu.sjsu.starbucks.api.response.OrderResponse;
import edu.sjsu.starbucks.api.response.UserResponse;
import edu.sjsu.starbucks.api.service.IAddCardService;
import edu.sjsu.starbucks.api.service.IManageOrderService;
import edu.sjsu.starbucks.api.service.IUserService;
import edu.sjsu.starbucks.model.common.CoffeeType;
import edu.sjsu.starbucks.model.common.OrderStatus;

@SpringBootTest
public class StarbucksAppTest extends AbstractTestNGSpringContextTests {

	@Autowired
	IManageOrderService manageOrderService;

	@Autowired
	IUserService userService;

	@Autowired
	IAddCardService addcardservice;
	
	@Test
	public void createUserTest() {
		String userName = "testUser" + System.currentTimeMillis();
		CreateUserRequest request = new CreateUserRequest();
		request.setUserName(userName);
		request.setPassword("testUser");
		
		UserResponse response = userService.createUser(request);
		assertEquals(response.getUserName(), userName);
		
	}
	
	@Test(priority=3)
	public void createOrderSuccess() {
		CreateOrderRequest request = new CreateOrderRequest();
		request.setUserName("testUser");
		
		List<CoffeeType> coffee = new ArrayList<>();
		coffee.add(CoffeeType.LATTE);
		request.setCoffee(coffee);
		
		OrderResponse response = manageOrderService.createOrder(request);
		assertEquals(response.getStatus(), OrderStatus.CREATED);
	}
	
	@Test(priority=1)
	public void addCardSuccess() {
		AddCardRequest request = new AddCardRequest();
		request.setUserName("testUser");
		request.setCardNumber("9611317679");
		request.setCvv(823);
		
		CardDetailsResponse response = addcardservice.addCard(request);
		assertNotNull(response.getCards());
		
	}
	
	@Test(priority=2)
	public void reloadCardSuccess() {
		double oldBalance = 0;
		double newBalance = 0;
		
		CardDetailsResponse cardResp = addcardservice.getCards("testUser");
		for(CardResponse dbCard : cardResp.getCards()) {
			if("9611317679".equals(dbCard.getCardNumber())) {
				oldBalance = dbCard.getBalance() + 20.0;
				break;
			}
		}
		ReloadCardRequest request = new ReloadCardRequest();
		request.setCardNumber("9611317679");
		request.setBalance(20.0);
		request.setUserName("testUser");
		
		CardDetailsResponse response = addcardservice.reloadCard(request);
		for(CardResponse dbCard : response.getCards()) {
			if("9611317679".equals(dbCard.getCardNumber())) {
				newBalance = dbCard.getBalance();
				break;
			}
		}
		assertEquals(newBalance, oldBalance);
	}
	
	@Test(priority=4)
	public void calculateOrderPayment() {
		CreateOrderRequest request = new CreateOrderRequest();
		request.setUserName("testUser");
		
		List<CoffeeType> coffee = new ArrayList<>();
		coffee.add(CoffeeType.LATTE);
		request.setCoffee(coffee);
		
		//OrderResponse response = manageOrderService.createOrder(request);
		//assertEquals(response.getStatus(), OrderStatus.CREATED);
	}
	
	@Test(priority=5)
	public void makePaymentSuccess() {
		
	}
}
