package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class InvoicePage extends BasePage{
	
	@FindBy(id = "SalesBuzz.Client:id/CashButton")
	WebElement cash_invoice_id;
	@FindBy(id = "SalesBuzz.Client:id/CheckButton")
	WebElement check_incoice_id;
	@FindBy(id = "SalesBuzz.Client:id/DeferredButton")
	WebElement defferd_invoice_id;
	@FindBy(id = "SalesBuzz.Client:id/CreditCardButton")
	WebElement credit_invoice_id;
	@FindBy(id = "SalesBuzz.Client:id/TemporaryButton")
	WebElement temporary_invoice_id;
	
	@FindBy(id = "SalesBuzz.Client:id/spinnerItemText")
	WebElement product_type_id;
	@FindBy(id = "SalesBuzz.Client:id/ReqQtyeditText")
	WebElement product_quantity_textbox_id;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView")
	WebElement product_type_piece_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView")
	WebElement product_type_carton_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout")
	WebElement product_promotion_element_exist_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	WebElement check_quantity_of_promotion;
	
	

	public InvoicePage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void choose_payment_method(String type)
	{
		if(type == "cash")
		{
			cash_invoice_id.click();
		}
		else if (type == "check")
		{
			check_incoice_id.click();
		}
		else if (type == "defferd")
		{
			defferd_invoice_id.click();
		}
		else if (type == "credit")
		{
			credit_invoice_id.click();
		}
		else if (type == "temporary")
		{
			temporary_invoice_id.click();
		}
	}
	
	
	
	
	public void click_product_type()
	{
		product_type_id.click();
	}
	public String check_product_type()
	{
		String check_type=product_type_id.getText(); 
		return check_type;
		
	}
	public void prduct_quantity_value(String value)
	{
		product_quantity_textbox_id.sendKeys(value);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	public void choose_product_type(String type)
	{
		if(type == "Piece")
		{
			product_type_piece_xpath.click();
		}
		else
		{
			product_type_carton_xpath.click();
		}
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
}
