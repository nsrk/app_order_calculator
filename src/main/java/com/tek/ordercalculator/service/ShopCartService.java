package com.tek.ordercalculator.service;

import com.tek.ordercalculator.model.Order;
import com.tek.ordercalculator.model.ShopCart;

/**
 * @author Sivaramakrishna
 *
 */
public interface ShopCartService {

	/**
	 * Method to start new transaction
	 * 
	 * @retun - returns a new cart is returned for each new transaction
	 * 
	 */
	public ShopCart startTransaction();
	
	/**
	 * Method to calculate price
	 * 
	 * @param - cart - contains all the orders
	 */
	public void calculatePrice(ShopCart cart);

	/**
	 * Method to check out order
	 * 
	 */

	public void checkOutOrder() throws Exception;
	
}
