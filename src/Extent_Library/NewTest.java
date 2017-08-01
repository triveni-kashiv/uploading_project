package Extent_Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewTest {
	
//ExtentReports reports;
//ExtentTest test;
ExtentClass ec = new ExtentClass();
@BeforeTest
public void beforeTest()
{
	//reports = new ExtentReports(System.getProperty("user.dir")+"/src/reports/logs"+".html");
	//test = reports.startTest("New Test..");

	ec.test = ec.reports.startTest("New Test....");
	ec.test.log(LogStatus.INFO, "We are in Test class.....");
}
	
  @Test
  public void f() {
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://www.google.com");
	  //test.log(LogStatus.INFO, "The browser window is opened");
  }
}

