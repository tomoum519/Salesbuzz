package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class VisitPage extends BasePage {
	
	
	@FindBy(id = "SalesBuzz.Client:id/SkipButtonWithText")
	WebElement skip_button_id;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]")
	WebElement invoice_xpath;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]")
	WebElement payment_xpath;
	
	@FindBy(id = "SalesBuzz.Client:id/VisitManagmentFinishButton")
	WebElement finish_visits_button_id;
	
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.Button")
	WebElement continue_visit_summary_xpath;
	
	public VisitPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void click_skip_button()
	{
		skip_button_id.click();
	}
	
	public void select_invoice()
	{
		invoice_xpath.click();
	}
	
	public void selectPayment()
	{
		payment_xpath.click();
	}
	
	public void finishVisitButton()
	{
		finish_visits_button_id.click();
	}
	
	public void continueVisitSummary()
	{
		continue_visit_summary_xpath.click();
	}
	
	

}
