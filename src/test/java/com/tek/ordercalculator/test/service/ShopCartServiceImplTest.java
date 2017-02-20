package com.tek.ordercalculator.test.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.ordercalculator.model.ShopCart;
import com.tek.ordercalculator.service.ShopCartService;
import com.tek.ordercalculator.service.ShopCartServiceImpl;

public class ShopCartServiceImplTest {

	private static ShopCartService shopCartService;
	@Before
	public void setUp()
	{
		shopCartService = new ShopCartServiceImpl();
	}
	
	@After
	public void destroy()
	{
		shopCartService = null;
	}
	
	@Test
	public void testStartTransaction()
	{
		Assert.assertEquals(shopCartService.startTransaction(),shopCartService.startTransaction());
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckOutOrderwithNullOrder() throws Exception
	{
		shopCartService.checkOutOrder();
	}
	@Test
	public void testCheckOutOrder() throws Exception
	{
		ShopCart shopCart = shopCartService.startTransaction();
		shopCart.addToCart("Book", 2.99, 1);
		shopCart.checkOutOrder();
	}
	@Test(expected = NullPointerException.class)
	public void testCheckOutOrderWithNullCartService() throws Exception{
		shopCartService = null;
		shopCartService.checkOutOrder();
	}
	
	@Test
	public void testCalculatePrice() throws Exception
	{
		ShopCart shopCart = shopCartService.startTransaction();
		shopCart.addToCart("Book", 2.99, 1);
		shopCart.checkOutOrder();
		shopCartService.calculatePrice(shopCart);
	}
	
	
	
}
