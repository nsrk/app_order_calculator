package com.tek.ordercalculator.test.model;

import org.junit.BeforeClass;
import org.junit.Test;

import com.tek.ordercalculator.model.Order;
import com.tek.ordercalculator.model.OrderLine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

/**
 * @author Sivaramakrishna
 *
 */
public class OrderTest {
	
	private static Order order;
	private static OrderLine orderLine;
	
	@Before
	public void setUp()
	{
		order = new Order();
	}
	
	@After
	public void clean()
	{
		order = null;
	}
	
	@Test(expected = NullPointerException.class)
	public void testOrderLineIsNull()
	{
		order.validateOrderLineParams(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddWithNullOrderLine() throws Exception
	{
		order.add(null);
	}

}
