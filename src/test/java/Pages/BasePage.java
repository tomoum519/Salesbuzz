package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import io.appium.java_client.android.AndroidKeyCode;

import com.google.inject.Key;

import TestCases.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage extends TestBase{
	
	protected AndroidDriver<MobileElement> driver;
	
	
	@FindBy(id = "android:id/button1")
	WebElement continue_or_ok_button_id;
	@FindBy(id = "android:id/search_button")
	WebElement search_button_id;
	@FindBy(id = "android:id/search_src_text")
	WebElement search_textbox_id;
	@FindBy(id = "SalesBuzz.Client:id/OrderScreenFinishButton")
	WebElement finsih_button_id;
	@FindBy(id = "android:id/button2")
	WebElement cancel_or_no_button_id;
	@FindBy(id = "android:id/message")
	WebElement message_id;
	@FindBy(id = "SalesBuzz.Client:id/action_search")
	WebElement filter_search_textbox_id;
	
	public BasePage(AndroidDriver<MobileElement> driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickContinueOrOkButtonAndroid() 
	{
		continue_or_ok_button_id.click();
	}
	public void cancelOrNoButton_android() 
	{
		cancel_or_no_button_id.click();
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
	
	public void waits()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	
	public double doubleConverter(String value) {
	    return Float.parseFloat(value);
	    
	}
	
	public String getMessage()
	{
		return message_id.getText();
	}
	
	public void filterSearchTextbox(String search)
	{
		filter_search_textbox_id.sendKeys(search);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void clearSearchTextBox()
	{
		search_textbox_id.clear();
	}
	
	protected void swipeLeft(WebElement swipeleft)
	{
		Dimension dimension = swipeleft.getSize();
		int arch = swipeleft.getSize().getHeight()/2;
		Double screenstartwidth = dimension.getWidth() * 0.8;
		int scrollstart = screenstartwidth.intValue();
		
		Double screenendwidth = dimension.getWidth() * 0.2;
		int scrollend = screenendwidth.intValue();
		
		new TouchAction((PerformsTouchActions)driver).press(PointOption.point(scrollstart, arch))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(scrollend,arch))
		.release().perform();
	}
	

}
