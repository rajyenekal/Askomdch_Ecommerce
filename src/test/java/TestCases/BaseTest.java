package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.JavaScriptUtil;
import Utilities.ReadConfigFile;

public class BaseTest {
	
	ReadConfigFile rcf=new ReadConfigFile();

	public String Url=rcf.getappurl();
	public String Username=rcf.getusernamel();
	public String Pwd=rcf.getPwd();
	public String menu=rcf.getMenu();
	public String store=rcf.getstore();
	public String prod=rcf.getprod();
	public String city=rcf.getcity();
	public String zipcode=rcf.getzip();
	public String streetadd=rcf.getstreetadd();
	public String mail=rcf.getmail();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("AskomdchEcommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
		driver.manage().window().maximize();
	}
	
		@AfterClass
		public void teardown() {
			driver.quit();
		}
		
		public void CaptureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot Captured");
		}
		
		JavaScriptUtil js=new JavaScriptUtil(driver);
		
}
