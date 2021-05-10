package TestCases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Data.ExcelReader;
import Data.LoadProperties;
import Pages.CustomersSelectionPage;
import Pages.HomePage;
import Pages.InvoicePage;
import Pages.LoginPage;
import Pages.PromotionApplied;
import Pages.VisitPage;
import Data.JsonDataReader;
import modular.NewVisteModular;




public class CheckPromotion extends TestBase {
	
	
	
	@Test()
	public void checkfreepiecespromotion() throws IOException, ParseException
	{
		JsonDataReader jsonReader = new JsonDataReader(); 
		jsonReader.JsonReader();
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.gotoinvoice();
		steps.chooseproduct("cash", jsonReader.product_name, jsonReader.product_value, jsonReader.product_type);
		
		
		PromotionApplied promotion = new PromotionApplied(driver);
		promotion.waits();
		assertTrue(promotion.check_promotion_element_for_extra_piece_exist());

		String check_quantity = promotion.check_product_quantity_promotion();
		int quantity = Integer.parseInt(check_quantity);
		int prodductvalue = Integer.valueOf(jsonReader.product_value).intValue();
		
		assertEquals(quantity, prodductvalue/2, "we have problem in promotion");
	}
	
	
	/*
	
	}
	
	@Test(dependsOnMethods = {"promotion_values"})
	public void check_discount() 
	{
		promotion = new PromotionApplied(driver);
		double product_price = promotion.check_price_of_the_product();
		double total_price_without_promotion_taxes = promotion.roundAvoid(product_price*20, 2);
		Assert.assertTrue(total_price_without_promotion_taxes==1000 && total_price_without_promotion_taxes > 1000);
		double Promotion_money = promotion.roundAvoid(total_price_without_promotion_taxes*(0.14), 2);
		
	}
	*/


}
