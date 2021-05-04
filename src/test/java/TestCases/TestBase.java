package TestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.reporters.TestHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	
	
	public static AndroidDriver<MobileElement> driver;
	public static ExtentReports extent;


	/*
	
	@BeforeSuite
	public void extentreport()
	{
	
	}
	
	*/
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName","PUG6R18B09000391");
		cap.setCapability("platformName","Android");
		cap.setCapability("appPackage","SalesBuzz.Client");
		cap.setCapability("appActivity","md5e2e3f5a0d2a847050c7d250bab01a99a.SplashScreen");
		cap.setCapability("automationName","UiAutomator1");	
		URL url = new URL("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url,cap);
		
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	    
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(spark);
		
		
		

	}
	
	@AfterSuite
	public void teardown() 
	{
		driver.quit();
		extent.flush();
	}

}
