package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class CartTest_0002 extends BaseTest {
	
	@Test
	public void addtoCart() throws IOException {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		
		hp.ClickMenu("Account");
		hp.verifyMenutext("Account");
		lp.logintoapp(Username, Pwd);
		
		hp.ClickMenu(store);
		logger.info("Clicked on "+store+" menu");
		hp.verifyMenutext(store);
		hp.SearchProd(prod);
		hp.verifyMenutext(prod);
		String firstprod = hp.Firstprod();
		logger.info("Verified "+store+" menu");
		CartPage cp=new CartPage(driver);
		
		cp.ClickcartProduct(firstprod);
		logger.info("Clicked on add to cart button on  "+firstprod+" ");
		cp.Clickviewcart(firstprod);
		logger.info("Verified view cart link of "+firstprod+" and clicked");
		
		if(cp.VerifyaddedtoCart(firstprod)) {
			logger.info("Product "+firstprod+" added to cart");
			Assert.assertTrue(true);
		}
		
		else {
			CaptureScreen(driver, "Cart Test");
			logger.info("Product not added to cart");
			Assert.assertTrue(false);
		}
	}
}
