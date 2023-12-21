package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class LoginTest_0001 extends BaseTest{
	
	@Test
	public void logintest() throws InterruptedException, IOException {
		
		logger.info("Navigated to URL");
		
		HomePage hp=new HomePage(driver);
		
		hp.ClickMenu(menu);
		logger.info("Clicked on  "+menu +"  Menu");
		hp.verifyMenutext(menu);
		logger.info("verified  "+menu+"  Menu");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.logintoapp(Username, Pwd);
		
		if(lp.HelloUser(Username)) {
			logger.info("Succesfully Logged in");
			Assert.assertTrue(true);
		}
		
		else {
			CaptureScreen(driver, "logintest");
			logger.info("Failed to Login");
			Assert.assertTrue(false);
			}
	}
	

}
