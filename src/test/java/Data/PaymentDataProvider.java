package Data;

import org.testng.annotations.DataProvider;

public class PaymentDataProvider {
	
	@DataProvider(name="cashpayment")
	public static Object[][] dataCashPayment()
	{
		return new Object[][] {
			{"carrefour market" , "6","1","piece"}
		};
	}
	
	@DataProvider(name="creditcardpayment")
	public static Object[][] dataCreditCardPayment()
	{
		return new Object[][] {
			{"carrefour market" , "6","1","piece"}
		};
	}
	
	@DataProvider(name="banktranssferpayment")
	public static Object[][] dataBankTranssfer()
	{
		return new Object[][] {
			{"carrefour market" , "6","1","piece"}
		};
	}

}
