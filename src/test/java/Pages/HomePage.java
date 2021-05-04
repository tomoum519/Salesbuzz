package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage{
	
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.Button")
	WebElement new_visit_xpath;
	
	public HomePage(AndroidDriver<MobileElement> driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public void click_new_visit()
	{
		boolean check = true;
		while(check)
		{
			try
			{ 
				new_visit_xpath.click();
				check =false;

			}
			catch(Exception e)
			{

				try
				{
					new_visit_xpath.isDisplayed();
					check = false;

				}
				catch(Exception s)
				{
					back_button();
				}




			}
			//new_visit_xpath.click();	

		}
	}
}
