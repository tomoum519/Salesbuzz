package TestCases;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

import org.testng.annotations.Test;

import Data.DataBaseReader;
import Pages.OrderConfirmationPage;
import modular.NewVisteModular;

public class CheckProductPrice extends TestBase {
	
	@Test
	public void checkProductprice() throws SQLException
	{
		/*
		DataBaseReader data = new DataBaseReader();
		data.setResult(data.DataBaseRead( "select i.ItemNameE , p.GrossSalePrice \r\n"
				+ "from HH_Item i, HH_ItemPrice p\r\n"
				+ "on i.ItemNo = p.ItemNo\r\n"
				+ "where p.ItemNo = \"1318754\" and p.SellingPriceCode = \"ws\" and p.UOM = \"CTN\"")
		);
		
		String itemname = data.getname();
		String price =data.getprice();
		
		NewVisteModular steps = new NewVisteModular(driver);
		OrderConfirmationPage promotion = new OrderConfirmationPage(driver);
		steps.login();
		steps.chooseCustomer("");
		steps.gotoinvoice();
		steps.chooseProduct("cash", itemname ,"1", "carbon");
		double product_price = promotion.doubleConverter(promotion.getPriceOfTheProduct());
		double dprice = Double.valueOf(price).doubleValue();
		assertEquals(promotion.roundAvoid(product_price, 2), dprice );
		*/
	}

}
