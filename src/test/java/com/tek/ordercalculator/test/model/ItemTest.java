package com.tek.ordercalculator.test.model;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;

import com.tek.ordercalculator.model.Item;
import com.tek.ordercalculator.model.ItemType;

/**
 * @author Sivaramakrishna
 *
 */
public class ItemTest {
	
	private static ItemType itemType;	
	private static Item item;
	
	@Before
	public void setUp() throws Exception
	{
		item = new Item("Imported bottle of perfume", 27.99);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testItemDescriptionIsNull() throws Exception
	{
		Item item = new Item(null,2.56);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testItemPriceIsZero() throws Exception
	{
		item = new Item("Imported bottle of perfume",0);
	}
	
	@Test
	public void testitemType()
	{
		assertEquals(itemType.IMPORTED,item.getItemType(item.getDescription()));
	}
	
	@Test
	public void validateItemArgs() throws Exception
	{
		item = new Item("Imported bottle of perfume",27.99);
		Assert.assertNotEquals(0, item.getPrice());
		Assert.assertNotNull(item.getDescription());
		Assert.assertEquals(ItemType.IMPORTED, item.getItemType(item.getDescription()));
	}

}
