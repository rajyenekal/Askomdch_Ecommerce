package TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;

public class ClickMenus_0003 extends BaseTest{
	
	
        
    @Test
    public void verifyallMenu() {
    	HomePage hp= new HomePage(driver);
    	
    	String [] S1 =new String [] {"Store","Men","Women","Accessories","Account","About","Contact Us"};
    	
    	for(String s2:S1) {
    		hp.ClickMenu(s2);
    		hp.verifyMenutext(s2);
    		logger.info("Verified "+s2+" Successfully");
    	}
    	
    	Assert.assertTrue(true);
    	
    }

	
	
	

}
