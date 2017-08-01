package Extent_Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotClass {

	public static String takeScreenShot(WebDriver driver ,String filename ) throws IOException
	{
		filename = filename+".png";
		String directory = "C:\\Users\\admin\\Documents\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory+filename));
		String destination = directory+filename;
		return destination;
	}

}
