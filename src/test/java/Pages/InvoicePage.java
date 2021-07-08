package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
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
	@FindBy(id = "SalesBuzz.Client:id/BankTransferButton")
	WebElement bank_transfer_invoice_id;
	
	@FindBy(id = "SalesBuzz.Client:id/spinnerItemText")
	WebElement product_type_id;
	@FindBy(id = "SalesBuzz.Client:id/ReqQtyeditText")
	WebElement product_quantity_textbox_id;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView")
	WebElement product_type_piece_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView")
	WebElement product_type_carton_xpath;
	

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")
	WebElement product_viewbox;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ImageView")
	WebElement screen_info_xpath;
	@FindBy(id = "SalesBuzz.Client:id/PriceTextView")
	WebElement product_price_id;
	@FindBy(id = "SalesBuzz.Client:id/ItemNameTextView")
	WebElement product_name_id;
	@FindBy(id = "SalesBuzz.Client:id/AvailableTextView")
	WebElement product_quantity_id;
	@FindBy(id = "SalesBuzz.Client:id/action_overflow")
	WebElement action_overflow_id;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
	WebElement conver_all_item_xpath;
	@FindBy(id = "SalesBuzz.Client:id/action_Filter")
	WebElement action_filter_id;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
	WebElement name_filter_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
	WebElement id_filter_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView")
	WebElement brand_filter_xpath;
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView")
	WebElement masterbrand_filter_xpath;
	@FindBy(className = "android.widget.Button" )
	List<WebElement> payment_types_class;
	
	
	

	public InvoicePage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void choosePaymentMethod(String type)
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
		else if (type == "bank")
		{
			bank_transfer_invoice_id.click();
		}
	}
	
	public void clickProductType()
	{
		product_type_id.click();
	}
	
	public String checkProductType()
	{
		String check_type=product_type_id.getText(); 
		return check_type;
		
	}
	
	public void prductQuantityValue(String value)
	{
		//TODO change press to back button and test
		product_quantity_textbox_id.sendKeys(value);
		//((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		back_button();
	}
	
	public void chooseProductType(String type)
	{
		if(type == "Piece" || type == "piece" || type == "PC")
		{
			product_type_piece_xpath.click();
		}
		else
		{
			product_type_carton_xpath.click();
		}
	}
	
	public void clickProductViewBox()
	{
		product_viewbox.click();
	}
	
	public void clickInfoButton()
	{
		screen_info_xpath.click();
	}
	
	public String getProductPrice()
	{
		return product_price_id.getText();
	}
	
	public String getProductName()
	{
		return product_name_id.getText();
	}
	
	public String getProductQuantity()
	{
		return product_quantity_id.getText();
	}
	
	public void clickActionList()
	{
		action_overflow_id.click();
	}
	
	public void clickConvertAllItems()
	{
		conver_all_item_xpath.click();
	}
	
	public String getProductType()
	{
		return product_type_id.getText();
	}
	
	public void clickFilterList()
	{
		action_filter_id.click();
	}
	
	public void clickNameFilter()
	{
		name_filter_xpath.click();
	}
	
	public void clickIdFilter()
	{
		id_filter_xpath.click();
	}
	
	public void clickBrandFilter()
	{
		brand_filter_xpath.click();
	}
	
	public void clickMasterBrandFilter()
	{
		masterbrand_filter_xpath.click();
	}
	
	public boolean checkProductViewBox()
	{
		
		boolean x = false;
		try
		{
			x = product_viewbox.isDisplayed();
		}catch (NoSuchElementException e) {
            System.err.println("Unable to find element");
            
        }
		return x;
		
	}
	
	public List<String> getPaymentTypes()
	{
		List<String> payments = new ArrayList<String>();
		 for(int i = 0; i<payment_types_class.size(); i++) {
	         //obtain text
	         String temp = payment_types_class.get(i).getText();
	         payments.add(temp);
	      }
		return payments;
	}
}
