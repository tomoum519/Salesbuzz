package TestCases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Data.PromotionDataProvider;
import Pages.OrderConfirmationPage;
import modular.NewVisteModular;


public class CheckPromotion extends TestBase {
	
	@Test(dataProvider="valuetovalue", dataProviderClass = PromotionDataProvider.class )
	public void checkValueToValue(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double valuepromotion = promotion.doubleConverter(promotion.getPromotionOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		double total_price_without_discount = product_price * enterd_quantite;
		double promotion_repeat = total_price_without_discount /100;
		double promotion_value = promotion_repeat * 5;
		assertEquals(promotion.roundAvoid(valuepromotion, 0), promotion_value,"Wrong calculation with value promotion");
		double total_taxes = (total_price_without_discount - promotion_value)*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation with Taxes");
		double total_price = (total_price_without_discount - promotion_value) + total_taxes;
		assertEquals(promotion.roundAvoid(totalvalue, 2), total_price,"Wrong calculation with total");
		
	}
	@Test(dataProvider="valuetopercantage" , dataProviderClass = PromotionDataProvider.class)
	public void checkValueToPercantage(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double valuepromotion = promotion.doubleConverter(promotion.getPromotionOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		
		double total_price_without_discount = product_price * enterd_quantite;
		double promotion_value = total_price_without_discount * 0.10;
		assertEquals(promotion.roundAvoid(valuepromotion, 0), promotion_value,"Something wrong with percantage promotion");
		double total_taxes = (total_price_without_discount - promotion_value)*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation with Taxes");
		double total_price = (total_price_without_discount - promotion_value) + total_taxes;
		assertEquals(promotion.roundAvoid(totalvalue, 2), total_price,"Wrong calculation with Total number");
	}
	
	// check boundry value of the free goods
	@Test(dataProvider="valuetogoods", dataProviderClass = PromotionDataProvider.class, groups = {"regression","SalesOrderRegression"})
	public void checkValueToFreeGoods(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		double total_price_without_discount = product_price * enterd_quantite;
		double total_taxes = total_price_without_discount*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation with Taxes");
		assertTrue(promotion.checkFreeGoodPromotionElement(), "no free gooda promotion");
		double count_free_goods = promotion.doubleConverter(promotion.getNumbersOfFreeGoods());
		double promotion_repeat = total_price_without_discount /200;
		assertEquals(count_free_goods, promotion_repeat,"wrong number of promotion");
		String free_good_type = promotion.getFreeGoodsType();
		assertEquals(free_good_type, "Piece","not the type that should be");
		
		
	}
	
	@Test(dataProvider="valuetonewprice", dataProviderClass = PromotionDataProvider.class)
	public void checkValueToNewPrice(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double valuepromotion = promotion.doubleConverter(promotion.getPromotionOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		
		double total_price_without_discount = product_price * enterd_quantite;
		double promotion_value = total_price_without_discount - (30 * enterd_quantite);
		assertEquals(promotion.roundAvoid(valuepromotion, 0), promotion_value,"Something wrong with new price promotion");
		double total_taxes = (total_price_without_discount - promotion_value)*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation with Taxes");
		double total_price = (total_price_without_discount - promotion_value) + total_taxes;
		assertEquals(promotion.roundAvoid(totalvalue, 2), total_price,"Wrong calculation with Total number");
	}
	
	@Test(dataProvider="quantitytovalue", dataProviderClass = PromotionDataProvider.class)
	public void checkQuantityToValue(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double valuepromotion = promotion.doubleConverter(promotion.getPromotionOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		
		double total_price_without_discount = product_price * enterd_quantite;
		double promotion_repeat = enterd_quantite/5;
		double promotion_value = promotion_repeat * 100;
		assertEquals(promotion.roundAvoid(valuepromotion, 0), promotion_value,"Something wrong with value promotion");
		
		double total_taxes = (total_price_without_discount - promotion_value)*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation with Taxes");
		double total_price = (total_price_without_discount - promotion_value) + total_taxes;
		assertEquals(promotion.roundAvoid(totalvalue, 2), total_price,"Wrong calculation with Total number");
	}
	
	
	@Test(dataProvider="quantitytopercantage", dataProviderClass = PromotionDataProvider.class)
	public void checkQuantityToPercantage(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double valuepromotion = promotion.doubleConverter(promotion.getPromotionOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		
		double total_price_without_discount = product_price * enterd_quantite;
		double promotion_value = total_price_without_discount * 0.10;
		assertEquals(promotion.roundAvoid(valuepromotion, 0), promotion_value,"Somthing wrong with the percantage promotion");
		double total_taxes = (total_price_without_discount - promotion_value)*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation in taxes");
		double total_price = (total_price_without_discount - promotion_value) + total_taxes;
		assertEquals(promotion.roundAvoid(totalvalue, 2), total_price,"Wrong calculation with Total number");
	}
	
	
	@Test(dataProvider="quantitytofreegoods", dataProviderClass = PromotionDataProvider.class)
	public void checkQuantityToFreeGoods(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		double total_price_without_discount = product_price * enterd_quantite;
		double total_taxes = total_price_without_discount*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation with Taxes");
		assertTrue(promotion.checkFreeGoodPromotionElement(), "no free gooda promotion");
		
		
		double count_free_goods = promotion.doubleConverter(promotion.getNumbersOfFreeGoods());
		int promotion_repeat =  (int) (enterd_quantite /5) ;
		assertEquals(count_free_goods, promotion_repeat*5);
		String free_good_type = promotion.getFreeGoodsType();
		assertEquals(free_good_type, "Piece");
		
		
	}
	
	
	@Test(dataProvider="quantitytonewprice", dataProviderClass = PromotionDataProvider.class)
	public void checkQuantityToNewPrice(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct(payment_method, product_name,product_value, product_type);
		
		
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		

		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double valuepromotion = promotion.doubleConverter(promotion.getPromotionOfTheProduct());
		double taxesvalue = promotion.doubleConverter(promotion.getTaxesOfTheProduct());
		double totalvalue = promotion.doubleConverter(promotion.getTotalOfTheProduct());
		double enterd_quantite = Double.valueOf(product_value).doubleValue();
		
		double total_price_without_discount = product_price * enterd_quantite;
		double promotion_value = total_price_without_discount - (30 * enterd_quantite);
		assertEquals(promotion.roundAvoid(valuepromotion, 0), promotion_value,"Something wrong with new price promotion");
		double total_taxes = (total_price_without_discount - promotion_value)*0.05;
		assertEquals(promotion.roundAvoid(taxesvalue, 2), total_taxes,"Wrong calculation with Taxes");
		double total_price = (total_price_without_discount - promotion_value) + total_taxes;
		assertEquals(promotion.roundAvoid(totalvalue, 2), total_price,"Wrong calculation with Total number");

	}
	



}
