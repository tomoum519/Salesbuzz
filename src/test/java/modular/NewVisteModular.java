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
		//test.pass("passed");
		
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
		newvisit.select_invoice();
	}
	
	public void chooseProduct(String payment_method,String product_name,String product_value,String product_type)
	{
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choose_payment_method(payment_method);
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
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		invoice.click_product_textbox();
		invoice.prduct_quantity_value(product_value);
		invoice.click_product_type();
		invoice.choose_product_type(product_type);
		invoice.back_button();
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
