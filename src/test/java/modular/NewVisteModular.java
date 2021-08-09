package modular;

import Pages.BasePage;
import Pages.CustomersSelectionPage;
import Pages.HomePage;
import Pages.InvoicePage;
import Pages.LoginPage;
import Pages.OrderConfirmationPage;
import Pages.VisitPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NewVisteModular extends BasePage {

	public NewVisteModular(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void login()
	{
		LoginPage login = new LoginPage(driver);
		//login.enter_password("123");
		login.click_login();
	}
	
	public void chooseCustomer(String choose_customer_name)
	{
		HomePage home = new HomePage(driver);
		CustomersSelectionPage customerselect = new CustomersSelectionPage(driver);	
		home.click_new_visit();		
		customerselect.click_menu();
		customerselect.click_route();
		customerselect.click_all_days();
		customerselect.search_button_android();
		customerselect.search_textbox_android(choose_customer_name);
		customerselect.select_customer(1);
		
	}
	
	public void gotoinvoice()
	{
		VisitPage newvisit = new VisitPage(driver);
		newvisit.click_skip_button();
		newvisit.click_skip_button();
		newvisit.click_skip_button();
		newvisit.clickContinueOrOkButtonAndroid();
		newvisit.select_invoice();
	}
	
	public void goToThirdRow()
	{
		VisitPage newvisit = new VisitPage(driver);
		newvisit.click_skip_button();
		newvisit.click_skip_button();
		newvisit.select_third_row();
	}
	
	public void chooseProduct(String payment_method,String product_name,String product_value,String product_type)
	{
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
		try
		{
			invoice.finsih_button_click();
		}catch (Exception e) {
			invoice.cancelOrNoButton_android();
			invoice.finsih_button_click();
		}
	}
	
	
	public double submitOrderConfirmationPageReturnTotalValue()
	{
		OrderConfirmationPage submit = new OrderConfirmationPage(driver);
		double totalvalue = submit.doubleConverter(submit.getTotalOfTheProduct());
		submit.clickFinishInOrderConfirmationPage();
		//submit.waits();
		submit.clickContinueOrOkButtonAndroid();
		return totalvalue;
	}
	
	public void payment()
	{
		VisitPage visit = new VisitPage(driver);
		visit.selectPayment();
	}
	

}
