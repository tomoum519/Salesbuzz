package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CustomersSelectionPage extends BasePage {
	
	private By menu_id = By.id("SalesBuzz.Client:id/action_overflow");
	private By route_xpath =By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]");
	private By all_days_xpath =By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[8]");
	private By select_cutomer_xpath =By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout");
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout")
	WebElement customer1;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout")
	WebElement customer2;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout")
	WebElement customer3;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.LinearLayout")
	WebElement customer4;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout")
	WebElement customer5;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.FrameLayout/android.widget.LinearLayout")
	WebElement customer6;
	private List<String> texts = new ArrayList<String>();
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
	public void select_customer(int choose_customer_postion)
	{
		if(choose_customer_postion == 1)
		{
			customer1.click();
		}
		else if (choose_customer_postion == 2)
		{
			customer2.click();
		}
		else if (choose_customer_postion == 3)
		{
			customer3.click();
		}
		else if (choose_customer_postion == 4)
		{
			customer4.click();
		}
		else if (choose_customer_postion == 5)
		{
			customer5.click();
		}
		else if (choose_customer_postion == 6)
		{
			customer6.click();
		}
		
	}
	
	// get text from many elements with the same class
	public void select_customername()
	{
		List<MobileElement> text = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		for (int i = 0; i < text.size(); i++) 
		{
			texts.add(text.get(i).getText());
            System.out.println(text.get(i).getText());
        }
	}
}
