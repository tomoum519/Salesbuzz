package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OrderConfirmationPage extends BasePage {
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout")
	WebElement product_promotion_element_exist_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	WebElement check_quantity_of_promotion;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
	WebElement price_of_the_product_xpath;
	@FindBy(id = "SalesBuzz.Client:id/TotalPromotionTextView" )
	WebElement promotion_value_id;
	@FindBy(id = "SalesBuzz.Client:id/TotalTaxTextView" )
	WebElement product_taxes_value_id;
	@FindBy(id = "SalesBuzz.Client:id/TotalValuetextView" )
	WebElement product_total_value_id;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]" )
	WebElement free_goods_promotion_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]" )
	WebElement free_goods_type_xpath;
	@FindBy(id = "SalesBuzz.Client:id/OrderConfirmFinishButton")
	WebElement order_confirmation_finish_button_id;

	public OrderConfirmationPage(AndroidDriver<MobileElement> driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public boolean check_promotion_element_for_extra_piece_exist()
	{
		boolean x = false;
		try
		{
			x = product_promotion_element_exist_xpath.isDisplayed();
		}catch (NoSuchElementException e) {
            System.err.println("Unable to find element");
            
        }
		return x;
		
	}
	
	public String getProductQuantityPromotion()
	{
		String check = check_quantity_of_promotion.getText();
		return check;
	}
	
	public String getPriceOfTheProduct() 
	{
		return price_of_the_product_xpath.getText();
	}
	
	public String getPromotionOfTheProduct() 
	{
		return promotion_value_id.getText();
	}
	
	public String getTaxesOfTheProduct() 
	{
		return product_taxes_value_id.getText();
	}
	
	public String getTotalOfTheProduct() 
	{
		return product_total_value_id.getText();
	}
	
	public String getNumbersOfFreeGoods()
	{
		return free_goods_promotion_xpath.getText();
	}
	
	public String getFreeGoodsType()
	{
		String free_good_type = free_goods_type_xpath.getText();
		return free_good_type;
	}
	
	public void clickFinishInOrderConfirmationPage()
	{
		order_confirmation_finish_button_id.click();
	}
	
	
	
}
