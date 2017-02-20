package com.tek.ordercalculator.main;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tek.ordercalculator.model.ShopCart;
import com.tek.ordercalculator.service.ShopCartService;
import com.tek.ordercalculator.service.ShopCartServiceImpl;


/**
 * @author Sivaramakrishna
 *
 */
public class OrderShopping {
	
	private static final Logger log = LoggerFactory.getLogger(OrderShopping.class); 
	
	/**
	 * Starting point for refactored order calculator code
	 * 
	 */
	public static void main(String[] args) throws Exception {

		ShopCartService service = new ShopCartServiceImpl();
		ShopCart cart = service.startTransaction();
		
		cart.addToCart("book", 12.49, 1);
		cart.addToCart("music CD", 14.99, 1);
		cart.addToCart("chocolate bar", 0.85, 1);
		service.checkOutOrder();
		log.info("Order 1 is checked out");

		cart.addToCart("imported box of chocolate", 10, 1);
		cart.addToCart("imported bottle of perfume",47.50, 1);
		service.checkOutOrder();
		log.info("Order 2 is checked out");
		
		cart.addToCart("Imported bottle of perfume", 27.99, 1);
		cart.addToCart("bottle of perfume", 18.99, 1);
		cart.addToCart("packet of headache pills", 9.75, 1);
		cart.addToCart("box of imported chocolates", 11.25, 1);
		service.checkOutOrder();
		log.info("Order 3 is checked out");
		
		service.calculatePrice(cart);
	}
}
