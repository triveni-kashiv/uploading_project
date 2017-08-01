package DataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtilityImplementation {
	public WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.letskodeit.com/");
		driver.findElement(By.xpath("//span[text()='Learn Now']")).click();
		// Tell the code about the location of Excel file
		ExcelUtilityClass.getXLSSheet("E:\\Excel Data Sheet\\Data1.xlsx", "Sheet2");
	}

	@DataProvider(name = "loginData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtilityClass.getTestData("Invalid_name");
		return testData;
	}

	@Test(dataProvider = "loginData")
	public void testUsingExcel(String username, String password) throws Exception {
		// Click login button
		driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
		Thread.sleep(2000);
		// Enter username
		driver.findElement(By.id("user_email")).sendKeys(username);
		// Enter password
		driver.findElement(By.id("user_password")).sendKeys(password);
		// Click Login button
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);

		// Find if error messages exist
		boolean result = driver.findElements(By.xpath("//form[@id='new_user']//div[3]")).size() != 0;
		Assert.assertTrue(result);
	}

	@AfterClass
	public void tearDown() throws Exception {
		// driver.quit();
	}
}