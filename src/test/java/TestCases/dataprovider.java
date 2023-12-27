/**
 * 
 */
package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Utilities.XLUtils;

/**
 * @author Admin
 *
 */
public class dataprovider extends BaseTest {

	@Test(dataProvider ="clickMenu" )
	public void clickMenus(String Menu) {
		
		HomePage hp= new HomePage(driver);
		hp.ClickMenu(Menu);
		hp.verifyMenutext(Menu);
		logger.info("Verified "+Menu+" Successfully");
		
		Assert.assertTrue(true);
	}
	
	
	
	
	
	@DataProvider(name="clickMenu")
	
	String [][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\AskomdchTestdata.xlsx";
		
		int rownum = XLUtils.getrowCount(path, "Sheet1");
		int colnum = XLUtils.getcellcount(path, "Sheet1", rownum);
		
		String clickMenus[][]=new String [rownum][colnum];
		
		for(int i=1;i<=rownum;i++) {
			
			clickMenus[i-1][0]=XLUtils.getCellData(path, "Sheet1", i, 0);
			
			}
		return clickMenus;
		}
	}

