package TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Utilities.XLUtils;

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
