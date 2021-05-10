package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PromotionApplied extends BasePage {
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout")
	WebElement product_promotion_element_exist_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	WebElement check_quantity_of_promotion;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
	WebElement price_of_the_product_xpath;

	public PromotionApplied(AndroidDriver<MobileElement> driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public boolean check_promotion_element_for_extra_piece_exist()
	{
		return product_promotion_element_exist_xpath.isDisplayed();
	}
	
	public String check_product_quantity_promotion()
	{
		String check = check_quantity_of_promotion.getText();
		return check;
	}
	
	public double check_price_of_the_product() 
	{
		double product_price =Float.parseFloat(price_of_the_product_xpath.getText());
		return product_price;
	}
	
}
