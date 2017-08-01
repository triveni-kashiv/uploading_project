package Extent_Library;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class GoogleSearch {
 ExtentReports reports;
 ExtentTest test;
 WebDriver driver;
 
 GoogleElementSearch ges;
 
  @BeforeClass
  public void beforeClass() {
	  reports = ExtentFactory.getInstance();
	  test = reports.startTest("Testing google page....");
	  driver = new FirefoxDriver();
	  driver.get("http://www.google.com");
	  test.log(LogStatus.INFO, "The WebBrowser is openend....");
	  test.log(LogStatus.INFO, "Google page is up....");
	  
	  ges = new GoogleElementSearch(driver, test);
	  
	  
  }

  @Test
  public void SignUpLink() {
	  ges.clickLogin();
  }
  
  @AfterClass
  public void afterClass() {
	  reports.endTest(test);
	  reports.flush();
	  driver.quit();
  }

}
