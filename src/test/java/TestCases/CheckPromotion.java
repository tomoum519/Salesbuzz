package TestCases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import Pages.CustomersSelectionPage;
import Pages.HomePage;
import Pages.InvoicePage;
import Pages.LoginPage;
import Pages.VisitPage;




public class CheckPromotion extends TestBase {
	
	@Test
	public void Login()
	{
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		LoginPage login = new LoginPage(driver);
		login.enter_password("123");
		login.click_login();
	}
	
	@Test(dependsOnMethods = {"Login"})
	public void check_invoice()
	{
		
		
		//InvoicePage invoice = new InvoicePage(driver);
		
		HomePage home = new HomePage(driver);
		//test.log(Status.FAIL, "test fail");
		//Assert.fail(" fail ");
		
		//test.fail("fail");
		//assertTrue(invoice.check_promotion_element_for_extra_piece_exist(), "faile");
		home.click_new_visit();
		//test.pass("passed");
		CustomersSelectionPage customerselect = new CustomersSelectionPage(driver);
		customerselect.click_menu();
		customerselect.click_route();
		customerselect.click_all_days();
		customerselect.select_customer();
		customerselect.continue_or_ok_button_android();
		VisitPage newvisit = new VisitPage(driver);
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
	
	@Test(dependsOnMethods = {"check_invoice"})
	public void check_promotion() 
	{
		InvoicePage invoice = new InvoicePage(driver);
		invoice.choose_payment_method("cash");
		invoice.search_button_android();
		invoice.search_textbox_android("castello mature");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout").click();
		invoice.prduct_quantity_value("20");
		invoice.click_product_type();
		invoice.choose_product_type("carbon");
		invoice.finsih_button_click();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//invoice.continue_or_ok_button_android();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertTrue(invoice.check_promotion_element_for_extra_piece_exist());

		String check_quantity = invoice.check_product_quantity_promotion();
		int quantity = Integer.parseInt(check_quantity);
		
		assertEquals(quantity, 10, "we have problem in promotion");
		
		
	}
	
	
	/*
	@Test()
	public void check_defferd()
	{
		ExtentTest test = extent.createTest("My third Test", "Sample description");
		InvoicePage invoice = new InvoicePage(driver);
		invoice.choose_payment_method("defferd");
		test.pass("select cash succesfully");
		invoice.search_button_android();
		invoice.search_textbox_android("castello mature");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		invoice.prduct_quantity_value("1");
		invoice.click_product_type();
		invoice.choose_product_type("Piece");
		invoice.finsih_button_click();
		test.pass("defferd");
	}

	*/

}
