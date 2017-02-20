package com.tek.ordercalculator.test.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tek.ordercalculator.main.OrderShopping;
import com.tek.ordercalculator.model.ShopCart;
import com.tek.ordercalculator.service.ShopCartService;
import com.tek.ordercalculator.service.ShopCartServiceImpl;

import junit.framework.Assert;

public class OrderShoppingTest {
	
	private static ShopCartService service;
	private static ShopCart cart;
	
	@Before
	public void setUp()
	{
		service = new ShopCartServiceImpl();
		cart = service.startTransaction();
	}
	
	@After
	public void clean()
	{
		service = null;
		cart = null;
	}

	
	@Test
	public void testMain() throws Exception{
		OrderShopping.main(null);
	}
	@Test
	public void testCartData() throws Exception
	{
		cart.addToCart("book", 12.49, 1);
		cart.addToCart("music CD", 14.99, 1);
		cart.addToCart("chocolate bar", 0.85, 1);
		service.checkOutOrder();
		Assert.assertNotNull(cart);
		service.calculatePrice(cart);
	}
}
