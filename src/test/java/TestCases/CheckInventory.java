package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.InventoryPage;
import modular.NewVisteModular;

public class CheckInventory extends TestBase {
	
	@Test
	public void checkProductsBiggerThanZero()
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		
		HomePage home = new HomePage(driver);
		home.clickInventory();
		InventoryPage inventory = new InventoryPage(driver);
		inventory.clickCarStore();
		boolean checkquantities = inventory.checkProductBiggerThanZero(inventory.getProductsQuantities());
		assertTrue(checkquantities,"quantities equal zero");
	}
	
	@Test
	public void checkThereIsConversionButton()
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		
		HomePage home = new HomePage(driver);
		home.clickInventory();
		InventoryPage inventory = new InventoryPage(driver);
		inventory.clickCarStore();
		inventory.clickCarStoreMenu();
		String convert = inventory.getConvert();
		if(convert.contains("Convert"))
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}

	@Test
	public void checkCarStoreScreenDisplayInfo()
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		
		HomePage home = new HomePage(driver);
		home.clickInventory();
		InventoryPage inventory = new InventoryPage(driver);
		inventory.clickCarStore();
		inventory.search_button_android();
		inventory.search_textbox_android("bounty");
		boolean checkquantities = inventory.checkProductBiggerThanZero(inventory.getProductsQuantities());
		
		String damaged = inventory.getDamaged();
		String sale = inventory.getSale();
		String transfer = inventory.getTransfer();
		if(damaged.contains("Damaged") && sale.contains("Sales") && transfer.contains("Transfer"))
		{
			assertTrue(checkquantities,"quantities equal zero");
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}		
	}
	
	@Test
	public void checkArrowForItemDetails()
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		
		HomePage home = new HomePage(driver);
		home.clickInventory();
		InventoryPage inventory = new InventoryPage(driver);
		inventory.clickCarStore();
		inventory.search_button_android();
		inventory.search_textbox_android("bounty");
		inventory.clickItemDetails();
		String itemdetails = inventory.getTitleIteamDetails();
		if(itemdetails.contains("Details"))
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
		
	}
}
