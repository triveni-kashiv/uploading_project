package Extent_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GoogleElementSearch {
	WebDriver driver = null;
	ExtentTest test;
	
	public GoogleElementSearch(WebDriver driver , ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}
	
	public void clickLogin()
	{
		WebElement ele = driver.findElement(By.id("gb_70"));
		  ele.click();
		  test.log(LogStatus.INFO, "Clicked on SigIn button.....");
	}

}
