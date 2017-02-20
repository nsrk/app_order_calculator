package com.tek.ordercalculator.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tek.ordercalculator.main.OrderShopping;

/**
 * @author Sivaramakrishna
 *
 */
public class OrderLine {

	private static final Logger log = LoggerFactory.getLogger(OrderLine.class); 
	private int quantity;
	private Item item;

	/**
	 * Constructor to set the item and quantity
	 * 
	 * @param - item of orderLine
	 * 
	 * @param - quantity of item
	 */
	public OrderLine(Item item, int quantity) throws Exception {
		
		validateOrderLineArgs(item,quantity);
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Method to get the item
	 * 
	 * @return - returns item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Method to get quantity
	 * 
	 * @return - returns quantity of item
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Method to validate orderLine parameters
	 *
	 * @param - item of orderLine
	 * 
	 * @param - quantity of item
	 * 
	 * @throws - throws an exception if item is null or empty (or) quantity is less than or equal to zero
	 */
	public void validateOrderLineArgs(Item item, int quantity) throws Exception
	{
		if(item==null)
		{
			log.error("The item is null");
			throw new NullPointerException("Item cannot be NULL");
		}
		if(quantity<=0)
		{
			log.error("The quantity is less than or equal to zero");
			throw new IllegalArgumentException("Item quantity should be greater than zero");
		}
	}
}
