package Interview_Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Alert_Test {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
  }

  @Test
  public void f() throws Exception {
	  String text = driver.switchTo().alert().getText();
	  driver.switchTo().frame(0);
	  
	  Set<String> getValue = driver.getWindowHandles();
	  Iterator<String> str = getValue.iterator();
	  System.out.println(str.next());
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  WebElement element = null;
	wait.until(ExpectedConditions.visibilityOf(element));
	  File srcFile = null;
	File destFile = null;
	FileUtils.copyFile(srcFile, destFile);
	  List<WebElement> eles = driver.findElements(By.xpath(""));
	  eles.size();
	 driver.findElement(By.xpath("")).sendKeys(Keys.TAB);
	  
  }
  
  @AfterMethod
  public void afterMethod() {
  }

}
