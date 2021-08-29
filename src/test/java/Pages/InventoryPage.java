package Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InventoryPage extends BasePage {
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
	WebElement car_store_xpath;
	@FindBy(id = "SalesBuzz.Client:id/AvailableQtytextView" )
	List<WebElement> products_quantities_id;
	@FindBy(id = "SalesBuzz.Client:id/action_overflow" )
	WebElement car_store_menu_id;
	@FindBy(id = "android:id/title" )
	WebElement convert_id;
	@FindBy(id = "SalesBuzz.Client:id/DamagedtextView" )
	WebElement damaged_id;
	@FindBy(id = "SalesBuzz.Client:id/SalestextView" )
	WebElement sale_id;
	@FindBy(id = "SalesBuzz.Client:id/TransferstextView" )
	WebElement transfer_id;
	@FindBy(id = "SalesBuzz.Client:id/ItemDetailsimageButton" )
	WebElement item_details_id;
	@FindBy(id = "android:id/action_bar_title" )
	WebElement title_item_details_id;
	
	
	public InventoryPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	public void clickCarStore()
	{
		car_store_xpath.click();
	}
	
	public List<Double> getProductsQuantities()
	{
		List<Double> Quantities = new ArrayList<Double>();
		 for(int i = 0; i<products_quantities_id.size(); i++) {
	         //obtain text
	         Double temp = doubleConverter(products_quantities_id.get(i).getText());
	         Quantities.add(temp);
	      }
		return Quantities;
	}
	
	public boolean checkProductBiggerThanZero(List<Double> Quantities)
	{
		boolean check = true;
		for(int i = 0; i<Quantities.size(); i++)
		{
			if(Quantities.get(i) <= 0)
			{
				check = false;
			}
		}
		return check;
		
	}
	
	public void clickCarStoreMenu()
	{
		car_store_menu_id.click();
	}
	
	public String getConvert()
	{
		return convert_id.getText();
	}
	
	public String getDamaged()
	{
		return damaged_id.getText();
	}
	
	public String getSale()
	{
		return sale_id.getText();
	}
	
	public String getTransfer()
	{
		return transfer_id.getText();
	}
	
	public void clickItemDetails()
	{
		item_details_id.click();
	}
	
	public String getTitleIteamDetails()
	{
		return title_item_details_id.getText();
	}
}
