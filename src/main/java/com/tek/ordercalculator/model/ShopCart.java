package com.tek.ordercalculator.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sivaramakrishna
 *
 */
public class ShopCart {

	private static final Logger log = LoggerFactory.getLogger(ShopCart.class);
	// add orders to the cart and maintain the Order history and check for current order
	public Order currentOrder;
	List<Order> totalOrders;
	
	/**
	 * Constructor to create/initialize a new order and total orders
	 */
	public ShopCart()
	{
		currentOrder = new Order();
		totalOrders = new ArrayList<Order>();
	}
	
	/**
	 * Method to get total orders
	 * 
	 * @return - returnds a list of total orders
	 */
	public List<Order> getTotalOrders() {
		return totalOrders;
	}

	/**
	 * Method to add items to cart
	 * 
	 * @param - returns name of an item
	 * 
	 * @param - returns price of an item
	 * 
	 * @param - returns quantity of item
	 * 
	 * @throws - throws Exception
	 */
	public void addToCart(String itemName, double itemPrice, int quantity) throws Exception
	{
		createOrderLine(new Item(itemName, itemPrice),quantity);	
	}
	
	/**
	 * Method to create OrderLine
	 * 
	 * @param - item of orderLine
	 * 
	 * @param - quantity of item
	 * 
	 * @throws - throws Exception
	 */
	public void createOrderLine(Item item, int quantity) throws Exception
	{
		createOrder(new OrderLine(item,quantity));
	}
	
	/**
	 * Method to create order
	 * 
	 * @param - orderLine
	 * 
	 * @throws  - throws Exception
	 */
	
	public void createOrder(OrderLine orderLine) throws Exception
	{
		currentOrder.add(orderLine);
	}
	
	/**
	 * Method to check out an order
	 * 
	 * @throws - throws exception if the order is null
	 * 
	 */
	public void checkOutOrder() throws Exception
	{
		if(currentOrder.getOrderLines()!=null && currentOrder.getOrderLines().size()>0)
		{
			totalOrders.add(currentOrder);
			currentOrder = new Order();
		}
		else{
			log.error("The order is null");
			throw new IllegalArgumentException("The order cannot be empty or NULL");
		}
	}
	
	
	
	
	
	
}
