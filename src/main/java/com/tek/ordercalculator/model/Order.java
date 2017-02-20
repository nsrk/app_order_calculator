package com.tek.ordercalculator.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tek.ordercalculator.main.OrderShopping;

/**
 * @author Sivaramakrishna
 *
 */
public class Order {
	
	private static final Logger log = LoggerFactory.getLogger(Order.class); 
	
	private static int count = 1;
	private final String orderNumber;
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	/**
	 * Constructor to set the orderNumber
	 */
	public Order()
	{
		orderNumber = "Order "+count;
		count++;
	}
	
	/**
	 * Method to get the orderNumber
	 * 
	 * @return - returns the order number
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	
	/**
	 * Method to get the list of order lines
	 * 
	 * @return - returns list of order lines
	 * 
	 */
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}


	/**
	 * Method to add validate orderLine and add to Order Line list
	 * 
	 * @param - orderLine
	 */
	public void add(OrderLine orderLine) throws Exception {
		validateOrderLineParams(orderLine);
		orderLines.add(orderLine);
	}

	/**
	 * Method to return size of the orderLines
	 * 
	 * @return - returns size of the orderLine list
	 */
	public int size() {
		return orderLines.size();
	}

	/**
	 * Method to get orderLine
	 * 
	 * @param - i is used to get list item
	 */
	public OrderLine get(int i) {
		return orderLines.get(i);
	}
	
	/**
	 * Method to validate OrderLine parameter
	 * 
	 * @param - orderLine
	 */
	public void validateOrderLineParams(OrderLine ol) throws NullPointerException
	{
		if(ol==null)
		{
			log.error("The order Line is null");
			throw new NullPointerException("The OrderLine cannot be NULL");
		}
	}
}
