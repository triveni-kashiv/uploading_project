package Extent_Library;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		//providing path for storing the extent report
		String path = "C:\\Users\\admin\\Desktop\\extentRrport.html";
		//with this extentRport we are provided with option of either replacing the contents of reports everytime by providing True or to enter new everytime by providing false
		extent = new ExtentReports(path, false).addSystemInfo("Selenium Version", "3.2").addSystemInfo("Platform",
				"Windows");

		return extent;
		
	}

}
