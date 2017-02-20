package com.tek.ordercalculator.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tek.ordercalculator.main.OrderShopping;

/**
 * @author Sivaramakrishna
 *
 */
public class Item {

		private static final Logger log = LoggerFactory.getLogger(Item.class); 
	
		private String description;
		private double price;
		private ItemType itemType ;

		/**
		 * Constructor to set the description and price of an item 
		 * 
		 * @param - description of an item
		 * 
		 * @param - price of an item
		 */
		public Item(String description, double price) throws Exception {
			validateItemObjVariables(description,price);
			itemType = getItemType(description);
			this.description = description;
			this.price = price;
		}

		/**
		 * Method to get the description of an item
		 * 
		 * @return - returns description of an item
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Method to get the price of an item
		 * 
		 * @return - returns price of an item
		 */
		public double getPrice() {
			return price;
		}
		
		
		/**
		 * Method to validate the Item Constructor Arguments
		 * 
		 * @param - description of an item
		 * 
		 * @param - price of an item
		 */
		private void validateItemObjVariables(String description, double price) throws Exception
		{
			if(description==null || description.equals(""))
			{
				log.error("The item description is null");
				throw new IllegalArgumentException("The description of an Item cannot be NULL or empty");
			}
			if(price<=0)
			{
				log.error("The item price is less than or equal to zero");
				throw new IllegalArgumentException("The price of an Item should be greater than zero");
			}
		}
		
		/**
		 * Method to get the type of an item
		 * 
		 * @param - description of an item
		 * 
		 * @return - returns item type
		 */
		public ItemType getItemType(String description)
		{
			ItemType itemType = ItemType.DOMESTIC;
			if(description.toLowerCase().contains("imported"))
			{
				itemType = ItemType.IMPORTED;
			}
			return itemType;
		}
	
	
}
