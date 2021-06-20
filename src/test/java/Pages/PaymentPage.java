package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PaymentPage extends BasePage {
	
	@FindBy(id = "SalesBuzz.Client:id/PayButton")
	WebElement pay_button_id;
	
	@FindBy(id = "SalesBuzz.Client:id/CreditCardDetailsButton")
	WebElement cradit_card_details_button_id;
	
	@FindBy(id = "SalesBuzz.Client:id/NetTotalTextView")
	WebElement net_total_textview_id;
	
	@FindBy(id = "SalesBuzz.Client:id/CreditCardCheckBox")
	WebElement credit_card_checkbox_id;
	
	@FindBy(id = "SalesBuzz.Client:id/action_Add")
	WebElement credit_card_add_action_id;
	
	@FindBy(id = "SalesBuzz.Client:id/PaidValueEditText")
	WebElement credit_card_paid_value_textbox_id;
	
	@FindBy(id = "SalesBuzz.Client:id/TransactionNoEditText")
	WebElement credit_card_transaction_textbox_id;
	
	@FindBy(id = "SalesBuzz.Client:id/Finishbutton")
	WebElement credit_card_finish_button_id;
	
	@FindBy(id = "SalesBuzz.Client:id/BanktTransferDetailsButton")
	WebElement bank_transfer_details_button_id;
	
	@FindBy(id = "SalesBuzz.Client:id/BankLookupButton")
	WebElement bank_lookup_button_id;
	
	@FindBy(id = "SalesBuzz.Client:id/QueryEditText")
	WebElement bank_search_bar_id;
	
	@FindBy(id = "SalesBuzz.Client:id/spinnerItemText")
	WebElement bank_name_field_id;

	@FindBy(id = "SalesBuzz.Client:id/BranchLookupButton")
	WebElement branch_lookup_button_id;
	
	@FindBy(id = "SalesBuzz.Client:id/TransactionNoEditText")
	WebElement transaction_check_number_textbox_id;
	
	
	public PaymentPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickPay()
	{
		pay_button_id.click();
	}
	
	public void clickCreditCardDetails()
	{
		cradit_card_details_button_id.click();
	}
	
	public String getNetTotal()
	{
		return net_total_textview_id.getText();
	}
	
	public void clickCreditCardAddAction()
	{
		credit_card_add_action_id.click();
	}
	
	public void writeCreditCardPaidValue(String total_value)
	{
		credit_card_paid_value_textbox_id.sendKeys(total_value);
	}
	
	public void writeCreditCardtransaction(String transaction)
	{
		credit_card_transaction_textbox_id.sendKeys(transaction);
	}
	
	public void clickCreditCardfinish()
	{
		credit_card_finish_button_id.click();
	}

	public void checkCreditCardCheckBox()
	{
		credit_card_checkbox_id.isSelected();
	}
	
	public void clickBankTransferDetails()
	{
		bank_transfer_details_button_id.click();
	}
	
	public void clickBankLookup()
	{
		bank_lookup_button_id.click();
	}
	
	public void writeInBanksAndBranchesSearchBar(String bank_name)
	{
		bank_search_bar_id.sendKeys(bank_name);
	}
	
	public void clickOnChosenBankOrBranches()
	{
		bank_name_field_id.click();
	}
	
	public void clickBranchLookup()
	{
		branch_lookup_button_id.click();
	}
	
	public void writeTransactionNumber(String transaction_number)
	{
		transaction_check_number_textbox_id.sendKeys(transaction_number);
	}
}
