package Extent_Library;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestClassExtent {
  public WebDriver driver;
  ExtentReports reports;
  ExtentTest test;
  @BeforeClass
  public void beforeClass() {
	  reports = ExtentFactory.getInstance();
	  test = reports.startTest("Verify sign-up Text");
	  driver = new FirefoxDriver();
	  test.log(LogStatus.INFO, "Browser launched.....");
	  driver.get("http://www.google.com");
	  test.log(LogStatus.INFO, "Url Launched....");
  }
  
  @Test
  public void TestClass() {
	  WebElement ele = driver.findElement(By.id("gb_70"));
	  ele.click();
	  test.log(LogStatus.INFO, "Clicked on SigIn button.....");
	  
	  WebElement text = null;
	  
	  try
	  {
		  text = driver.findElement(By.id("headingText"));
	  }
	  catch(NoSuchElementException e)
	  {
		  Assert.assertTrue(text !=null);
		  test.log(LogStatus.PASS, "Test is passed.....");
	  }
  }
  @AfterMethod
  public void AfterMethod(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		 String path =  ScreenShotClass.takeScreenShot(driver,result.getName());
		 String imagePath = test.addScreenCapture(path);
		 test.log(LogStatus.FAIL, "Verifying Login Tect failed" , imagePath);
	  }
	  reports.endTest(test);
	  reports.flush();
	  driver.close();
  }

}
