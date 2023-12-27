package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title=\"View your shopping cart\"]")
	@CacheLookup
	WebElement cartIcon;
	
	public void clickCarticon() {
		cartIcon.click();
	}
	
	public void ClickcartProduct(String prod) {
	WebElement cartprod = ldriver.findElement(By.xpath("//h2[.='"+prod+"']/../..//a[contains(@class,'add_to_cart')]"));
	cartprod.click();
	}
	
	public void Clickviewcart(String prod) {
		WebElement viewcart = ldriver.findElement(By.xpath("//h2[.='"+prod+"']/../..//a[contains(@class,'add_to_cart')]/..//a[@title=\"View cart\"]"));
		viewcart.isDisplayed();
		viewcart.click();
	}
	
	public Boolean VerifyaddedtoCart(String prod) {
		WebElement prodinCart = ldriver.findElement(By.xpath("//td[@data-title=\"Product\"]//a[.='"+prod+"']"));
		return prodinCart.isDisplayed();
	}
	
}
