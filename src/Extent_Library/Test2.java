package Extent_Library;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Test2 {
 
	ExtentReports reports;
	ExtentTest test;
	
  @BeforeClass
  public void beforeClass() {
	 
	  reports = ExtentFactory.getInstance();
	  test = reports.startTest("Starting Test2 Class Test......");
  }
  
  @Test
  public void f() {
	  
	  test.log(LogStatus.PASS, "Starting the test....");
	  test.log(LogStatus.INFO, "The Test is in its middle of execution.....");
	  test.log(LogStatus.INFO, "Test is executing contiunosly......");
	  test.log(LogStatus.INFO, "Test is completed......");
	  
  }

  @AfterClass
  public void afterClass() {
	  reports.endTest(test);
	  reports.flush();
  }

}
