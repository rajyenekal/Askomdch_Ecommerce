package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id="username")
	@CacheLookup
	WebElement userName;
	
	@FindBy (id="password")
	@CacheLookup
	WebElement password;
	
	@FindBy (name="login")
	@CacheLookup
	WebElement loginbtn;
	
	public void logintoapp(String username,String Pwd) {
		userName.sendKeys(username);
		password.sendKeys(Pwd);
		loginbtn.click();
	
	}
	
	public boolean HelloUser(String Uname) {
		WebElement username = ldriver.findElement(By.xpath("//p[contains(.,'Hello') and contains(.,'"+Uname+"')]"));
		return username.isDisplayed();
	} 
	
}
