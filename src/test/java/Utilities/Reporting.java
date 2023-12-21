package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentSparkReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
public void onStart(ITestContext testContext) {
		
		//Timestamp
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
		//Specify Path
		htmlreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		try {
			htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		extent=new  ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Rajaneesh");
		
		//Set Title of Report
		htmlreporter.config().setDocumentTitle("AskomdchEcommerce Test Project");
		
		htmlreporter.config().setReportName("Functional Test Report");
		
		htmlreporter.config().setTheme(Theme.DARK);

	}
	
	public void onTestSuccess(ITestResult tr) {
		//Create new entry in the report
		logger=extent.createTest(tr.getName());
		
		//if passed mark it Green
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String ScreenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f=new File(ScreenShotPath);
		
		if(f.exists()) {
			try {
				logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(ScreenShotPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void OnTestSkippped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
