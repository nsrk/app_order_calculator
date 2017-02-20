package com.tek.ordercalculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tek.ordercalculator.model.Order;
import com.tek.ordercalculator.model.ShopCart;
import com.tek.ordercalculator.util.PriceCalculator;

/**
 * @author Sivaramakrishna
 *
 */
public class ShopCartServiceImpl implements ShopCartService {

	private static final Logger log = LoggerFactory.getLogger(ShopCartServiceImpl.class); 
	public ShopCart cart;
	
	
	/**
	 * Method to start new transaction
	 * 
	 * @retun - returns a new cart is returned for each new transaction
	 * 
	 */
	public ShopCart startTransaction() {
		
		if(cart==null)
		{
			cart = new ShopCart();
			log.info("New cart is created");
		}
		return cart;
	}
	
	/**
	 * Method to check out order
	 * 
	 */
	public void checkOutOrder() throws Exception {
		cart.checkOutOrder();
		
	}

	/**
	 * Method to calculate price
	 * 
	 * @param - cart - contains all the orders
	 */
	public void calculatePrice(ShopCart cart) {
		PriceCalculator.calculatePrice(cart);
		
	}

	
}
