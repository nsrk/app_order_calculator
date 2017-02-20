package com.tek.ordercalculator.test.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tek.ordercalculator.model.Item;
import com.tek.ordercalculator.model.OrderLine;
import com.tek.ordercalculator.model.ShopCart;
import com.tek.ordercalculator.service.ShopCartService;
import com.tek.ordercalculator.service.ShopCartServiceImpl;
import com.tek.ordercalculator.util.PriceCalculator;

/**
 * @author Sivaramakrishna
 *
 */
public class PriceCalculatorTest {

	private static ShopCartService shopCartService = new ShopCartServiceImpl();
	private static ShopCart shopCart;
	
	@Before
	public void setUp()
	{
		shopCart = shopCartService.startTransaction();
	}
	
	@After
	public void clean()
	{
		shopCart = null;
	}
	
	
	@Test
	public void testRoundingToTwoDecimalPlaces()
	{
		Assert.assertEquals(3.46, PriceCalculator.roundUptoTwoDecimalPlaces(3.457),0.00);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullOrders() throws IllegalArgumentException
	{
		PriceCalculator.calculatePrice(null);
	}
	
	@Test
	public void testCalculateItemTaxAmount() throws Exception
	{
		double itemTax = PriceCalculator.calculateItemTaxAmount(new OrderLine(new Item("box of Imported chocolates", 6.51), 1));
		Assert.assertEquals(0.98, itemTax,0.00);
	}
	
	
	
}
