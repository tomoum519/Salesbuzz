package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import io.appium.java_client.android.AndroidKeyCode;

import com.google.inject.Key;

import TestCases.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class BasePage extends TestBase{
	
	protected AndroidDriver<MobileElement> driver;
	
	private By continue_or_ok_button_id = By.id("android:id/button1");
	
	@FindBy(id = "android:id/search_button")
	WebElement search_button_id;
	@FindBy(id = "android:id/search_src_text")
	WebElement search_textbox_id;
	@FindBy(id = "SalesBuzz.Client:id/OrderScreenFinishButton")
	WebElement finsih_button_id;
	
	public BasePage(AndroidDriver<MobileElement> driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void continue_or_ok_button_android() 
	{
		driver.findElement(continue_or_ok_button_id).click();
	}
	public void back_button()
	{
		driver.navigate().back();
	}
	
	public void search_button_android()
	{
		search_button_id.click();
	}
	
	public void search_textbox_android(String search)
	{
		search_textbox_id.sendKeys(search);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	
	public void finsih_button_click()
	{
		finsih_button_id.click();
	}
	
	

}
