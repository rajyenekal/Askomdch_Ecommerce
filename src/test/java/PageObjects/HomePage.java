package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (id="woocommerce-product-search-field-0")
	@CacheLookup
	WebElement searchfield;
	
	@FindBy (xpath="//h2[contains(@class,'product__title')]")
	@CacheLookup
	WebElement FirstProd;
	
	public void ClickMenu(String menu) {
		WebElement clickmenu = ldriver.findElement(By.xpath("//div[@class=\"main-navigation ast-inline-flex\"]//ul//li//a[.='"+menu+"']"));
		clickmenu.click();
	}
	
	public void verifyMenutext(String text) {
		WebElement accountText = ldriver.findElement(By.xpath("//h1[contains(.,'"+text+"')]"));
		accountText.isDisplayed();
	}
	

	public void SearchProd(String prod) {
		searchfield.sendKeys(prod);
		searchfield.sendKeys(Keys.ENTER);
	}
	
	public String Firstprod() {
		String firstProd = FirstProd.getText();
		return firstProd;
	}


}
