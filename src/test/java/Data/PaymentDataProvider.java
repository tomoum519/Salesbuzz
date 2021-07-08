package Data;

import org.testng.annotations.DataProvider;

public class PaymentDataProvider {
	
	@DataProvider(name="cashpayment")
	public static Object[][] dataCashPayment()
	{
		return new Object[][] {
			// customer name | product name| product quantity | product type
			{"carrefour market" , "6","1","piece"}
		};
	}
	
	@DataProvider(name="creditcardpayment")
	public static Object[][] dataCreditCardPayment()
	{
		return new Object[][] {
			// customer name | product name| product quantity | product type | transaction number
			{"carrefour market" , "6","1","piece","123"}
		};
	}
	
	@DataProvider(name="banktranssferpayment")
	public static Object[][] dataBankTranssfer()
	{
		return new Object[][] {
			// customer name | product name| product quantity | product type | bank name | transaction number
			{"carrefour market" , "6","1","piece","HS","123"}
		};
	}

}
