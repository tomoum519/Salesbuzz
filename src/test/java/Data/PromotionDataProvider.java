package Data;

import org.testng.annotations.DataProvider;

public class PromotionDataProvider {

	@DataProvider(name="valuetovalue")
	public static Object[][] checkvaluetovalue()
	{
		return new Object[][] {
			{"hyper one market" , "cash" , "Caramel chocolate","4","carbon"}
			//,{"hyper one market","cash","Caramel chocolate","1","carbon"}
		};
	}
	
	
	@DataProvider(name="valuetopercantage")
	public static Object[][] valuetopercantage()
	{
		return new Object[][] {
			{"carrefour market" , "cash" , "wafers","10","carbon"}
			//,{"carrefour market", "cash","wafers","1","carbon"}
		};
	}
	
	@DataProvider(name="valuetogoods")
	public static Object[][] checkvaluetogoods()
	{
		return new Object[][] {
			{"hyper one market" , "cash" , "wafers","4","carbon"}
			//,{"hyper one market" , "cash","wafers","1","carbon"}
		};
	}
	
	@DataProvider(name="valuetonewprice")
	public static Object[][] checkvaluetonewprice()
	{
		return new Object[][] {
			{"metro market" , "cash" , "wafers","4","carbon"}
			//,{"metro market" , "cash","wafers","1","carbon"}
		};
	}
	
	@DataProvider(name="quantitytovalue")
	public static Object[][] checkquantitytovalue()
	{
		return new Object[][] {
			{"bonjour" , "cash" , "Caramel chocolate","5","carbon"}
			,{"bonjour" , "cash","Caramel chocolate","1","carbon"}
		};
	}
	
	@DataProvider(name="quantitytopercantage")
	public static Object[][] checkquantitytopercantage()
	{
		return new Object[][] {
			{"bonjour" , "cash" , "bounty","5","carbon"}
			
		};
	}
	
	@DataProvider(name="quantitytofreegoods")
	public static Object[][] checkquantitytofreegoods()
	{
		return new Object[][] {
			{"bonjour" , "cash" , "wafers","6","carbon"}
			,{"bonjour" , "cash","wafers","5","carbon"}
			,{"bonjour" , "cash","wafers","10","carbon"}
		};
	}
	
	
	@DataProvider(name="quantitytonewprice")
	public static Object[][] checkquantitytonewprice()
	{
		return new Object[][] {
			{"metro market" , "cash" , "wafers","6","carbon"}
			//,{"metro market" , "cash","wafers","5","carbon"}
			//,{"metro market" , "cash","wafers","10","carbon"}
		};
	}
}
