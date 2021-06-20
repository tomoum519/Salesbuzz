package TestCases;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;
import Data.PaymentDataProvider;
import Pages.PaymentPage;
import Pages.VisitPage;
import modular.NewVisteModular;

public class CheckPaymentTypes extends TestBase{
	
	
	
	@Test(dataProvider="cashpayment", dataProviderClass = PaymentDataProvider.class )
	public void checkCashPayment(String customer_name, String product_name, String product_value,String product_type)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct("cash",product_name, product_value, product_type);// 6
		double total_price = steps.submitOrderConfirmationPageReturnTotalValue();
		VisitPage visit = new VisitPage(driver);
		visit.selectPayment();
		PaymentPage pay = new PaymentPage(driver);
		pay.back_button();
		double net_total = pay.doubleConverter(pay.getNetTotal());
		assertEquals(net_total, total_price,"wrong total");
		pay.clickPay();
		pay.clickContinueOrOkButtonAndroid();
		pay.cancelOrNoButton_android();
		visit.finishVisitButton();
		visit.continueVisitSummary();
		
	}
	
	@Test(dataProvider="creditcardpayment", dataProviderClass = PaymentDataProvider.class)
	public void checkCreditCardPayment(String customer_name, String product_name, String product_value,String product_type,String transaction_number)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct("credit", product_name, product_value, product_type);
		double total_price = steps.submitOrderConfirmationPageReturnTotalValue();
		VisitPage visit = new VisitPage(driver);
		visit.selectPayment();
		PaymentPage pay = new PaymentPage(driver);
		double net_total = pay.doubleConverter(pay.getNetTotal());
		assertEquals(net_total, total_price,"wrong total");
		pay.clickCreditCardDetails();
		pay.clickCreditCardAddAction();
		pay.writeCreditCardPaidValue(pay.getNetTotal());
		pay.writeCreditCardtransaction(transaction_number);
		pay.back_button();
		pay.clickCreditCardfinish();
		pay.clickContinueOrOkButtonAndroid();
		pay.clickPay();
		pay.clickContinueOrOkButtonAndroid();
		pay.cancelOrNoButton_android();
		visit.finishVisitButton();
		visit.continueVisitSummary();
		
	}
	
	

	@Test(dataProvider="banktranssferpayment", dataProviderClass = PaymentDataProvider.class)
	public void checkBankTransferPayment(String customer_name, String product_name, String product_value,String product_type,String bank_name,String transaction_number)
	{
		NewVisteModular steps = new NewVisteModular(driver);
		steps.login();
		steps.chooseCustomer(customer_name);
		steps.gotoinvoice();
		steps.chooseProduct("bank", product_name, product_value, product_type);
		double total_price = steps.submitOrderConfirmationPageReturnTotalValue();
		VisitPage visit = new VisitPage(driver);
		visit.selectPayment();
		PaymentPage pay = new PaymentPage(driver);
		double net_total = pay.doubleConverter(pay.getNetTotal());
		assertEquals(net_total, total_price,"wrong total");
		pay.clickBankTransferDetails();
		pay.clickBankLookup();
		pay.writeInBanksAndBranchesSearchBar(bank_name);
		pay.clickOnChosenBankOrBranches();
		pay.writeTransactionNumber(transaction_number);
		pay.clickContinueOrOkButtonAndroid();
		pay.clickPay();
		pay.clickContinueOrOkButtonAndroid();
		pay.cancelOrNoButton_android();
		visit.finishVisitButton();
		visit.continueVisitSummary();
	}
	

}
