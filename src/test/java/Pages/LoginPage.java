package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage
{
	@FindBy(id = "SalesBuzz.Client:id/SalesmanPasswordEditText")
	WebElement password_id;
	@FindBy(id = "SalesBuzz.Client:id/LoginButton")
	WebElement login_button_id;

	
	
	public LoginPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void enter_password(String password )
	{
		
		password_id.sendKeys(password);
	}
	
	public void click_login() 
	{
		login_button_id.click();
	}

}
