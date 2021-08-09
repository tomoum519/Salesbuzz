package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ItemInfoPage extends BasePage{
	
	@FindBy(id = "SalesBuzz.Client:id/ItemInfoLongNameValueTextView")
	WebElement product_name_id;
	@FindBy(id = "SalesBuzz.Client:id/ItemInfoItemCurrStockValueTextView")
	WebElement product_quantity_id;
	@FindBy(id = "SalesBuzz.Client:id/ItemInfoPriceValueTextView")
	WebElement product_price_id;
	@FindBy(className = "android.widget.ScrollView" )
	WebElement scroll_view_class;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText")
	WebElement UOM_details_carton_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText")
	WebElement UOM_details_piece_xpath;
	@FindBy(id = "SalesBuzz.Client:id/action_finish")
	WebElement finsih_id;

	public ItemInfoPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getProductName()
	{
		return product_name_id.getText();
	}
	
	public String getProductQuantity()
	{
		return product_quantity_id.getText();
	}
	
	public String getProductPrice()
	{
		return product_price_id.getText();
	}
	
	public void swipeToUnitMeasureScreen()
	{
		swipeLeft(scroll_view_class);
	}
	
	public void chooseAndUpdateUint(String unit, String quantity)
	{
		if(unit.equals("carton"))
		{
			UOM_details_carton_xpath.sendKeys(quantity);
		}
		else
		{
			UOM_details_piece_xpath.sendKeys(quantity);
		}
	}
	
	public void clickFinish()
	{
		finsih_id.click();
	}

}
