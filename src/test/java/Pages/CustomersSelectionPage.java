package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CustomersSelectionPage extends BasePage {
	
	private By menu_id = By.id("SalesBuzz.Client:id/action_overflow");
	private By route_xpath =By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
	private By all_days_xpath =By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[8]");
	private By select_cutomer_xpath =By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout");

	public CustomersSelectionPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void click_menu()
	{
		driver.findElement(menu_id).click();
	}
	public void click_route()
	{
		driver.findElement(route_xpath).click();
	}
	public void click_all_days()
	{
		driver.findElement(all_days_xpath).click();
	}
	public void select_customer()
	{
		driver.findElement(select_cutomer_xpath).click();
	}
}
