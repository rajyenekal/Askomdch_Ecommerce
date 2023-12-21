package TestCases;

import org.testng.annotations.Test;

import PageObjects.BillingPage;
import PageObjects.CartPage;
import PageObjects.ChrckoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class Checkout_0004 extends BaseTest {
	
	@Test
	public void checkout() throws InterruptedException {
		
		CartPage cp=new CartPage(driver);
		HomePage hp = new HomePage(driver);
		ChrckoutPage chp= new ChrckoutPage(driver);
		LoginPage lp= new LoginPage(driver);
		BillingPage bp=new BillingPage(driver);
		
		hp.ClickMenu("Account");
		lp.logintoapp(Username, Pwd);
		Thread.sleep(500);
		cp.clickCarticon();
		logger.info("Clicked on Cart");
		hp.verifyMenutext("Cart");
		chp.Scrollproceedcheckout();
		chp.clickchangeAddress();
		logger.info("Clicked on change address");
		chp.shippingCity(city);
		logger.info("Entered city");
		chp.shippingPostCode(zipcode);
		logger.info("Entered code");
		chp.clickupdate();
		logger.info("clicked update");
		//Thread.sleep(3000);
		
		if(chp.shippingto(city, zipcode)) {
			logger.info("Shipped to data verified");
			Thread.sleep(2000);
			chp.clickproceedCheckout();
			logger.info("clicked on proceed to checkout");
		}
		
		hp.verifyMenutext("Checkout");
		
		bp.firstName(Username);
		bp.lastName("kb");
		
		bp.billCompany("Zomeo");
		
		bp.StreetAdd().matches(streetadd);
		
		bp.billCity().matches(city);
		logger.info("Entered firstname and lastname");
		//Thread.sleep(5000);
		//bp.billState().matches("California");
		bp.PostCode().matches(zipcode);
		bp.Mail().matches(mail);
		bp.click_Cod();
		bp.place_Order();
		
		if(bp.orderSuccess()) {
			logger.info("order Number is "+bp.orderNumber());
			logger.info("Order date is "+bp.orderDate());
			logger.info("Order Mail is "+bp.orderMail());
			logger.info("Order Total is"+bp.orderTotal());
			logger.info("Order Method is "+bp.orderMethod());
		}
		
		
		
		
		
		
	}
}
