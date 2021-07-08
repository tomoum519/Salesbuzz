package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ItemInfoPage extends BasePage{
	
	@FindBy(id = "SalesBuzz.Client:id/ItemInfoLongNameValueTextView")
	WebElement product_name_id;
	@FindBy(id = "SalesBuzz.Client:id/ItemInfoItemCurrStockValueTextView")
	WebElement product_quantity_id;
	@FindBy(id = "SalesBuzz.Client:id/ItemInfoPriceValueTextView")
	WebElement product_price_id;

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
	
	

}
