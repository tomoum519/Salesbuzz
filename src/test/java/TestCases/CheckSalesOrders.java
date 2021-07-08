package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Data.PromotionDataProvider;
import Data.SalesOrderDataBase;
import Data.SalesOrderDataProvider;
import Pages.InvoicePage;
import Pages.ItemInfoPage;
import Pages.OrderConfirmationPage;
import modular.NewVisteModular;

public class CheckSalesOrders extends TestBase {
	
	@Test(dataProvider="checkScreenInfoOfItem",groups = {"regression","SalesOrderRegression"} ,dataProviderClass = SalesOrderDataProvider.class )
	public void checkScreenInfoOfItem(String customer,String productname)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		
		steps.login();
		steps.chooseCustomer(customer);
		steps.gotoinvoice();
		
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choosePaymentMethod("cash");
		try
		{
			invoice.search_button_android();
		}catch (Exception e) 
		{
			invoice.cancelOrNoButton_android();
			invoice.search_button_android();
		}
		
		invoice.search_textbox_android(productname);
		String product_name = invoice.getProductName();
		String product_quantity = invoice.getProductQuantity();
		String product_price = invoice.getProductPrice();
		invoice.clickInfoButton();
		
		ItemInfoPage info = new ItemInfoPage(driver);
		assertEquals(product_name,info.getProductName(), "wrong name");
		assertEquals(product_quantity,info.getProductQuantity(), "wrong name");
		assertEquals(product_price,info.getProductPrice(), "wrong name");
	}

	
	
	@Test(dataProvider="checkConvertAllItems", dataProviderClass = SalesOrderDataProvider.class ,groups = {"regression","SalesOrderRegression"})
	public void checkConvertAllItems(String customer,String productname)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		
		steps.login();
		steps.chooseCustomer(customer);
		steps.gotoinvoice();
		
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choosePaymentMethod("cash");
		try
		{
			invoice.clickActionList();
		}catch (Exception e) {
			invoice.cancelOrNoButton_android();
			invoice.clickActionList();
		}
		invoice.clickConvertAllItems();
		String msg = invoice.getMessage();
		invoice.clickContinueOrOkButtonAndroid();
		invoice.search_button_android();
		invoice.search_textbox_android(productname);
		invoice.clickProductViewBox();
		if(msg.contains("small"))
		{
			assertEquals(invoice.getProductType(), "Piece","wrong in small convert");
		}else if(msg.contains("large"))
		{
			assertEquals(invoice.getProductType(), "Carton","wrong in large convert");
		}else
		{
			assertFalse(true,"msg changed");
		}
		
	}
	
	
	@Test(dataProvider="checkSearch", dataProviderClass = SalesOrderDataProvider.class, groups = {"regression","SalesOrderRegression"})
	public void checkSearch(String customer,String product_id,String product_name)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		SoftAssert softassertion = new SoftAssert();
		
		steps.login();
		steps.chooseCustomer(customer);
		steps.gotoinvoice();
		
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choosePaymentMethod("cash");
		invoice.clickFilterList();
		invoice.clickNameFilter();
		invoice.search_button_android();
		invoice.search_textbox_android(product_name);
		softassertion.assertTrue(invoice.checkProductViewBox(), "no item found");
		
		invoice.clickFilterList();
		invoice.clickIdFilter();
		invoice.search_textbox_android(product_id);
		softassertion.assertTrue(invoice.checkProductViewBox(), "no item found");

		softassertion.assertAll();
		
	}
	
	
	@Test(dataProvider="checkcurrentquantity", dataProviderClass = SalesOrderDataProvider.class, groups = {"regression","SalesOrderRegression"} )
	public void checkAvaibleQuantity(String customer,String product_id) throws SQLException
	{
		SalesOrderDataBase read = new SalesOrderDataBase();
		read.avaibleQuantityQuery(product_id);
		String databasequantity = read.getFirstColunmResult();
		NewVisteModular steps = new NewVisteModular(driver);
		
		steps.login();
		steps.chooseCustomer(customer);
		steps.gotoinvoice();
		
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choosePaymentMethod("cash");
		try
		{
			invoice.search_button_android();
		}catch (Exception e) 
		{
			invoice.cancelOrNoButton_android();
			invoice.search_button_android();
		}
		
		invoice.clickFilterList();
		invoice.clickIdFilter();
		invoice.search_textbox_android(product_id);
		String product_quantity = invoice.getProductQuantity();
		
		double quantity = invoice.doubleConverter(product_quantity);
		double dbquantity = invoice.roundAvoid(invoice.doubleConverter(databasequantity), 2);
		
		assertEquals(quantity, dbquantity,"wrong quantity");
	}
	
	
	@Test(dataProvider="checkunitprice", dataProviderClass = SalesOrderDataProvider.class, groups = {"regression","SalesOrderRegression"} )
	public void checkUnitPrice(String customer,String product_id,String product_type) throws SQLException
	{
		SalesOrderDataBase read = new SalesOrderDataBase();
		read.unitPriceQuery(product_id, customer, product_type);
		String databaseprice = read.getFirstColunmResult();
		
		assertNotNull(databaseprice, "nothing in the database with this data");
		NewVisteModular steps = new NewVisteModular(driver);
		
		steps.login();
		steps.chooseCustomer(customer);
		steps.gotoinvoice();
		
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choosePaymentMethod("cash");
		try
		{
			invoice.search_button_android();
		}catch (Exception e) 
		{
			invoice.cancelOrNoButton_android();
			invoice.search_button_android();
		}
		
		invoice.clickFilterList();
		invoice.clickIdFilter();
		invoice.search_textbox_android(product_id);
		invoice.clickProductViewBox();
		invoice.clickProductType();
		invoice.chooseProductType(product_type);
		String product_price = invoice.getProductPrice();
		double pprice = invoice.doubleConverter(product_price);
		double dbprice = invoice.roundAvoid(invoice.doubleConverter(databaseprice), 0);
		
		assertEquals(dbprice, pprice,"wrong price");
		
		if("CTN"==product_type)
		{
			invoice.clickProductType();
			invoice.chooseProductType("PC");
			String product_change_price = invoice.getProductPrice();
			read.factorCalculationQuery(product_id);
			double factor_piece_price = invoice.doubleConverter(read.getFirstColunmResult());
			double dbpieceprice = dbprice / factor_piece_price; 
			dbpieceprice = invoice.roundAvoid(dbpieceprice, 2);
			double pieceprice = invoice.roundAvoid(invoice.doubleConverter(product_change_price),2);
			assertEquals(dbpieceprice, pieceprice,"wrong piece price");
		}
		else
		{

			invoice.clickProductType();
			invoice.chooseProductType("CTN");
			String product_change_price = invoice.getProductPrice();
			read.factorCalculationQuery(product_id);
			double factor_piece_price = invoice.doubleConverter(read.getFirstColunmResult());
			double dbpieceprice = dbprice * factor_piece_price; 
			dbpieceprice = invoice.roundAvoid(dbpieceprice, 2);
			double pieceprice = invoice.roundAvoid(invoice.doubleConverter(product_change_price),2);
			assertEquals(dbpieceprice, pieceprice,"wrong piece price");
		}
		
	}
	
	
	
	@Test(dataProvider="checkdefaultunit", dataProviderClass = SalesOrderDataProvider.class, groups = {"regression","SalesOrderRegression"} )
	public void checkDefaultUnit(String customer,String product_id) throws SQLException
	{
		SalesOrderDataBase read = new SalesOrderDataBase();
		read.defaultUnitQuery(product_id);
		String database_default_type = read.getFirstColunmResult();
		NewVisteModular steps = new NewVisteModular(driver);
		
		steps.login();
		steps.chooseCustomer(customer);
		steps.gotoinvoice();
		
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choosePaymentMethod("cash");
		try
		{
			invoice.search_button_android();
		}catch (Exception e) 
		{
			invoice.cancelOrNoButton_android();
			invoice.search_button_android();
		}
		
		invoice.clickFilterList();
		invoice.clickIdFilter();
		invoice.search_textbox_android(product_id);
		invoice.clickProductViewBox();
		String product_default_type = invoice.getProductType();
		if(database_default_type.equals("CTN"))
		{
			assertEquals("Carton", product_default_type,"wrong default uint");
		}else if(database_default_type.equals("PC"))
		{
			assertEquals("Piece", product_default_type,"wrong default uint");
		}
		
	}
	
	
	@Test(dataProvider="checkpaymenttypes", dataProviderClass = SalesOrderDataProvider.class, groups = {"regression","SalesOrderRegression"} )
	public void checkPaymentTypes(String customer,List<String> payments)
	{
		
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer);
		steps.gotoinvoice();
		
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		List<String> payment_types = invoice.getPaymentTypes();
		assertTrue(payments.containsAll(payment_types));
		
	}
	
	@Test(dataProvider="checkItemInfoReflectInOrderConfirmation", dataProviderClass = SalesOrderDataProvider.class, groups = {"regression","SalesOrderRegression"})
	public void checkItemInfoReflectInOrderConfirmation(String customer_name, String payment_method,String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choosePaymentMethod(payment_method);
		try
		{
			invoice.search_button_android();
		}catch (Exception e) 
		{
			invoice.cancelOrNoButton_android();
			invoice.search_button_android();	
		}
		invoice.search_textbox_android(product_name);
		invoice.waits();
		invoice.clickProductViewBox();
		invoice.prductQuantityValue(product_value);
		invoice.clickProductType();
		invoice.chooseProductType(product_type);
		String getproductname = invoice.getProductName();
		String productprice = invoice.getProductPrice();
		try
		{
			invoice.finsih_button_click();
		}catch (Exception e) {
			invoice.cancelOrNoButton_android();
			invoice.finsih_button_click();
		}
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		promotion.waits();
		
		String product_price = promotion.getPriceOfTheProduct();
		String productname = promotion.getProductName();
		String productquantity = promotion.getProductQuantity();
		assertEquals(productquantity, product_value);
		assertEquals(productname, getproductname);
		assertEquals(product_price, productprice);
	}
}
