package com.tek.ordercalculator.test.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tek.ordercalculator.model.Item;
import com.tek.ordercalculator.model.OrderLine;


public class OrderLineTest {

	private static OrderLine orderLine;
	
	@Before
	public void setUp() throws Exception
	{
		orderLine = new OrderLine(new Item("Imported bottle of perfume",27.99),1);
	}
	
	@After
	public void clean()
	{
		orderLine = null;
	}
	
	@Test(expected = NullPointerException.class)
	public void testItemIsNull() throws Exception
	{
		orderLine.validateOrderLineArgs(null, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testQuantityIsZero() throws Exception
	{
		orderLine.validateOrderLineArgs(orderLine.getItem(), 0);
	}
	
	@Test
	public void testOrderLineArgs()
	{
		Assert.assertNotNull(orderLine.getItem());
		Assert.assertNotNull(orderLine.getQuantity());
		Assert.assertNotNull(orderLine.getItem().getDescription());
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetItem() throws Exception
	{
		orderLine = new OrderLine(null, 1);
		orderLine.getItem();
	}
	
	

}
