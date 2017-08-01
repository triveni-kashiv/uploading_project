package DataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityClass {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell ;
	
	public void setExcelFile(String Filename , String path)
	{
		try
		{
		FileInputStream fis = new FileInputStream(path);
		
		wb = new XSSFWorkbook(fis);
		
		sheet = wb.getSheet(Filename);
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
	}

}
