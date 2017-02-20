package com.tek.ordercalculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tek.ordercalculator.model.ItemType;
import com.tek.ordercalculator.model.Order;
import com.tek.ordercalculator.model.OrderLine;
import com.tek.ordercalculator.model.ShopCart;

public class PriceCalculator {

	private static final Logger log = LoggerFactory.getLogger(PriceCalculator.class);
	
	private static final double importedItemTaxPercentage = 0.15;
	
	private static final double domesticItemTaxPercentage = 0.10;

	/**
	 * Method to calculate price of the entire cart
	 * 
	 * @param - cart - cart holds all the orders
	 */
	public static void calculatePrice(ShopCart cart) throws IllegalArgumentException {
		double grandTotal = 0;
		double totalTaxAmount = 0;
		if (cart != null && !cart.getTotalOrders().isEmpty()) {
			for (Order order : cart.getTotalOrders()) {
				double orderTotalTax = 0;
				double orderTotalAmount = 0;
			
				System.out.println("*******" + order.getOrderNumber() + "*******");
				
				for(OrderLine orderLine : order.getOrderLines())
				{
					double itemPrice = orderLine.getItem().getPrice() * orderLine.getQuantity();
					double itemTax = calculateItemTaxAmount(orderLine);
					calculateItemTotalAmount(orderLine,itemTax);
					orderTotalAmount+=itemPrice;
					orderTotalTax+=itemTax;
				}
				System.out.println("Sales Tax: "+roundUptoTwoDecimalPlaces(orderTotalTax));
				System.out.println("Total: "+roundUptoTwoDecimalPlaces(orderTotalAmount));
				grandTotal+=orderTotalAmount;
				totalTaxAmount+=orderTotalTax;
				
			}
			System.out.println("Sum of Orders: "+grandTotal);
			log.info("Sum of Orders is: "+grandTotal);
			
		}
		else{
			log.error("The cart is null");
			throw new IllegalArgumentException("The cart cannot be NULL or empty");
		}

	}

	/**
	 * Method to calculate total amount of an item
	 * 
	 * @param -orderLine - contains item
	 * 
	 * @param - tax of an item
	 */
	public static void calculateItemTotalAmount(OrderLine orderLine, double itemTax) {
		
		double afterTaxItemPrice = orderLine.getItem().getPrice()+itemTax;
		System.out.println(orderLine.getQuantity()+" "+orderLine.getItem().getDescription()+" "+roundUptoTwoDecimalPlaces(afterTaxItemPrice));
		//log.info(orderLine.getQuantity()+" "+orderLine.getItem().getDescription()+" "+roundUptoTwoDecimalPlaces(afterTaxItemPrice));
	}
	
	/**
	 * Method to calculate tax amount of an item
	 * 
	 * @param -orderLine - contains item
	 * 
	 * @return - tax amount of an item
	 */
	public static double calculateItemTaxAmount(OrderLine orderLine)
	{
		int quantity = orderLine.getQuantity();
		double itemPrice = orderLine.getItem().getPrice();
		String description = orderLine.getItem().getDescription();
		double itemTax = 0;
		if(orderLine.getItem().getItemType(description).equals(ItemType.IMPORTED))
		{
			itemTax = roundUptoTwoDecimalPlaces(itemPrice * quantity * importedItemTaxPercentage);
		}
		else{
			itemTax = roundUptoTwoDecimalPlaces(itemPrice * quantity * domesticItemTaxPercentage);
		}
		
		return itemTax;
	}
	
	/**
	 * Method to round off value to two decimal places
	 * 
	 * @param - value before rounding to two decimal places
	 * 
	 * @return - rounded off value
	 */
	public static double roundUptoTwoDecimalPlaces(double value)
	{
		
		BigDecimal roundOffValue = new BigDecimal(value).setScale(2, RoundingMode.HALF_DOWN);
		return roundOffValue.doubleValue();
		
	}
}
