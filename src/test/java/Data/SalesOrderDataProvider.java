package Data;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;

public class SalesOrderDataProvider {
	
	@DataProvider(name="checkScreenInfoOfItem")
	public static Object[][] checkScreenInfoOfItem()
	{
		return new Object[][] {
			{"carrefour","oat"}
		};
	}
	
	@DataProvider(name="checkConvertAllItems")
	public static Object[][] checkConvertAllItems()
	{
		return new Object[][] {
			{"carrefour","oat"}
		};
	}
	
	@DataProvider(name="checkSearch")
	public static Object[][] checkSearch()
	{
		return new Object[][] {
			{"carrefour","111166","oat"}
		};
	}
	
	@DataProvider(name="checkcurrentquantity")
	public static Object[][] checkCurrentQuantity()
	{
		return new Object[][] {
			{"carrefour","111166"}
		};
	}
	
	@DataProvider(name="checkunitprice")
	public static Object[][] checkUnitPrice()
	{
		return new Object[][] {
			{"carrefour","111166","CTN"}
		};
	}
	
	
	@DataProvider(name="checkdefaultunit")
	public static Object[][] checkDefaultUnit()
	{
		return new Object[][] {
			{"carrefour","111166"}
		};
	}
	
	@DataProvider(name="checkpaymenttypes")
	public static Object[][] checkPaymentTypes()
	{
		List<String> payments =  Arrays.asList("Check","Cash","Deferred","Credit Card","Temporary Credit","E-Payment","Bank Transfer");
		return new Object[][] {
			{"carrefour",payments}
		};
	}
	
	@DataProvider(name="checkItemInfoReflectInOrderConfirmation")
	public static Object[][] checkItemInfoReflectInOrderConfirmation()
	{
		return new Object[][] {
			{"carrefour","cash" , "wafer","4","carbon"}
		};
	}
	
	@DataProvider(name="checkSalesOrderAddQuantityBiggerThanStock")
	public static Object[][] checkSalesOrderAddQuantityBiggerThanStock()
	{
		return new Object[][] {
			{"carrefour","cash","golden","40"}
		};
	}
	
	@DataProvider(name="checkCustomerJourny")
	public static Object[][] checkCustomerJourny()
	{
		List<String> customernames =  Arrays.asList("Carrefour Market","Hyper One Market","Metro Market","Kheir Zaman Market","Spinneys Market","Bonjour");
		return new Object[][] {
			{"sunday",customernames}
		};
	}
	
	@DataProvider(name="checkUnitMeasureScreenAndUpdate")
	public static Object[][] checkUnitMeasureScreenAndUpdate()
	{
		return new Object[][] {
			{"carrefour","golden","carton","5"}
		};
	}
}
