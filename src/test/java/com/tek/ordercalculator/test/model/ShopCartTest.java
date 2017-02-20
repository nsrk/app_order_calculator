package com.tek.ordercalculator.test.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tek.ordercalculator.model.Item;
import com.tek.ordercalculator.model.Order;
import com.tek.ordercalculator.model.OrderLine;
import com.tek.ordercalculator.model.ShopCart;
import com.tek.ordercalculator.service.ShopCartService;
import com.tek.ordercalculator.service.ShopCartServiceImpl;

import static org.junit.Assert.*;

import org.junit.After;

public class ShopCartTest {
	
	private static ShopCart shopCart;

	
	@Before
	public void setUp() throws Exception{
		
		ShopCartService service = new ShopCartServiceImpl();
		shopCart = service.startTransaction();
	}
	
	@After
	public void clean()
	{
		shopCart = null;
	}

	@Test(expected = NullPointerException.class)
	public void testCreateOrderCartNull() throws Exception
	{
		shopCart = null;
		shopCart.createOrder(new OrderLine(new Item("Imported bottle of perfume", 27.99),1));
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreateOrderWithNull() throws Exception
	{
		shopCart.createOrder(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreateOrderLineWithNull() throws Exception
	{
		shopCart.createOrderLine(null, 1);
	}

	@Test
	public void testAddtoCart() throws Exception
	{
		shopCart.addToCart("Imported bottle of perfume", 27.99, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddToCartWithNullDescription() throws Exception
	{
		shopCart.addToCart(null, 27.99, 1);
	}
	
	
	
}
