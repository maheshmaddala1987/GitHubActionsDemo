package Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class SingletonReportTest {
	
	 WebDriver driver;
	 ExtentReports extent ;
	 ExtentTest test;
	 LoggerSingleton logger;
	
	@BeforeClass 
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		extent = ExtentManager.getExtentReports();  	
		logger = LoggerSingleton.getInstance();
	}
	
	@Test
	public void sampleTestWithSingleton() {
	    test = extent.createTest("sampleTestWithSingleton","Add the class to report");
		ExtentManager.setTest(test);
		logger.info("Test started in log...");
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test.info("launched google chrome");
		logger.info("aunched google chrome in log...");
		
	}
	
	@AfterClass
	public void tearDown() {
		test.info("closing google chrome");
		logger.info("close the browser in log.........");
		ExtentManager.flush();
		driver.quit();
		
	}

}
