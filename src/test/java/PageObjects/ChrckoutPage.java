package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Utilities.JavaScriptUtil;

public class ChrckoutPage extends BasePage{

	public ChrckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//a[contains(.,'Proceed to checkout')]")
	@CacheLookup
	WebElement proceedtocheckoutElement;
	
	@FindBy (xpath="//a[contains(.,'Proceed to checkout')]")
	@CacheLookup
	WebElement proceedtocheckoutElement1;
	
	@FindBy (xpath="//a[.='Change address']")
	@CacheLookup
	WebElement changeaddress;
	
	@FindBy (id="calc_shipping_city")
	@CacheLookup
	WebElement shippingCity;
	
	@FindBy (id="calc_shipping_postcode")
	@CacheLookup
	WebElement shippingPostCode;
	
	@FindBy (name="calc_shipping")
	@CacheLookup
	WebElement updateBtn;
	
	
	
	public void Scrollproceedcheckout() {
		JavaScriptUtil js= new JavaScriptUtil(ldriver);
		js.jsScrollIntoView(true, proceedtocheckoutElement);
	}
	
	public void clickproceedCheckout() {
		proceedtocheckoutElement1.click();
	}
	
	public void clickchangeAddress() {
		changeaddress.click();
	}
	
	public void shippingCity(String city) {
		shippingCity.clear();
		shippingCity.sendKeys(city);
	}
	
	public void shippingPostCode(String code) {
		shippingPostCode.clear();
		shippingPostCode.sendKeys(code);
	}
	
	public void clickupdate() {
		updateBtn.click();
	}
	
	public boolean shippingto(String city,String code) {
		WebElement shippingTo = ldriver.findElement(By.xpath("//strong[contains(.,'"+city+"') and contains(.,'"+code+"')]"));
		return shippingTo.isDisplayed();
	}
	
}
