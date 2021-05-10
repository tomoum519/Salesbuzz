package modular;

import Pages.BasePage;
import Pages.CustomersSelectionPage;
import Pages.HomePage;
import Pages.InvoicePage;
import Pages.LoginPage;
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
		login.enter_password("123");
		login.click_login();
	}
	
	public void gotoinvoice()
	{
		HomePage home = new HomePage(driver);
		CustomersSelectionPage customerselect = new CustomersSelectionPage(driver);
		VisitPage newvisit = new VisitPage(driver);
		
		home.click_new_visit();
		//test.pass("passed");
		
		customerselect.click_menu();
		customerselect.click_route();
		customerselect.click_all_days();
		customerselect.select_customer();
		customerselect.continue_or_ok_button_android();
		
		newvisit.click_skip_button();
		newvisit.continue_or_ok_button_android();
		newvisit.click_skip_button();
		newvisit.continue_or_ok_button_android();
		newvisit.click_skip_button();
		newvisit.click_skip_button();
		newvisit.continue_or_ok_button_android();
		newvisit.click_skip_button();
		newvisit.click_skip_button();
		newvisit.select_invoice();
	}
	
	public void chooseproduct(String payment_method,String product_name,String product_value,String product_type)
	{
		InvoicePage invoice = new InvoicePage(driver);
		invoice.waits();
		invoice.choose_payment_method(payment_method);
		invoice.search_button_android();
		invoice.search_textbox_android(product_name);
		invoice.waits();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		invoice.click_product_textbox();
		invoice.prduct_quantity_value(product_value);
		invoice.click_product_type();
		invoice.choose_product_type(product_type);
		invoice.finsih_button_click();
	}
	
	
	

}
