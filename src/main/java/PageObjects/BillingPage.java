package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BillingPage extends BasePage{

	public BillingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id="billing_first_name")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy (id="billing_last_name")
	@CacheLookup
	WebElement LastName;
	
	@FindBy (id="billing_company")
	@CacheLookup
	WebElement BillCompany;
	
	@FindBy (id="billing_address_1")
	@CacheLookup
	WebElement BillAdd1;
	
	@FindBy (id="billing_address_2")
	@CacheLookup
	WebElement BillAdd2;
	
	@FindBy (id="billing_city")
	@CacheLookup
	WebElement BillCity;
	
	@FindBy (id="select2-billing_state-container")
	@CacheLookup
	WebElement BillState;
	
	@FindBy (id="billing_postcode")
	@CacheLookup
	WebElement PostCode;
	
	@FindBy (id="billing_phone")
	@CacheLookup
	WebElement PhoneNO;
	
	@FindBy (id="billing_email")
	@CacheLookup
	WebElement Mail;
	
	@FindBy (id="payment_method_cod")
	@CacheLookup
	WebElement Cod;
	
	@FindBy (id="place_order")
	@CacheLookup
	WebElement placeOrder;
	
	@FindBy (xpath="//p[.='Thank you. Your order has been received.']")
	@CacheLookup
	WebElement orderSuccess;
	
	@FindBy (xpath="//li[contains(@class,'order order')]/strong")
	@CacheLookup
	WebElement orderNumber;
	
	@FindBy (xpath="//li[contains(@class,'date date')]/strong")
	@CacheLookup
	WebElement orderDate;
	
	@FindBy (xpath="//li[contains(@class,'email')]/strong")
	@CacheLookup
	WebElement orderEmail;
	
	@FindBy (xpath="//li[contains(@class,'total')]/strong")
	@CacheLookup
	WebElement orderTotal;
	
	@FindBy (xpath="//li[contains(@class,'method')]/strong")
	@CacheLookup
	WebElement orderMethod;
	
	public void firstName(String name) {
		FirstName.clear();
		FirstName.sendKeys(name);
	}
	
	public void lastName(String name) {
		LastName.clear();
		LastName.sendKeys(name);
	}
	
	public void billCompany(String name) {
		LastName.sendKeys(name);
	}
	
	public String StreetAdd() {
		BillAdd1.click();
		String billValue = BillAdd1.getAttribute("value");
		return billValue;
		
	}
	
	public String billCity() {
		BillCity.click();
		String bilcity = BillCity.getAttribute("value");
		return bilcity;
	}
	
	public String billState() {
		BillState.click();
		String billState = BillState.getAttribute("value");
		return billState;
		
	}
	
	public String PostCode() {
		PostCode.click();
		String bilcity = BillCity.getAttribute("value");
		return bilcity;
	}
	
	public String Mail() {
		Mail.click();
		String mail = Mail.getAttribute("value");
		return mail;
	}
	
	public void click_Cod() {
		Cod.click();
	}
	
	public void place_Order() {
		placeOrder.click();
	}
	
	public Boolean orderSuccess() {
		return orderSuccess.isDisplayed();
	}
	
	public String orderNumber() {
		String ordeNum = orderNumber.getText();
		return ordeNum;
		
	}
	
	public String orderDate() {
		String ordeDate = orderDate.getText();
		return ordeDate;
		
	}
	
	public String orderMail() {
		String ordemail = orderEmail.getText();
		return ordemail;
		
	}
	
	public String orderTotal() {
		String ordertotal = orderTotal.getText();
		return ordertotal;
		
	}
	
	public String orderMethod() {
		String ordemethod = orderMethod.getText();
		return ordemethod;
		
	}
	
}
