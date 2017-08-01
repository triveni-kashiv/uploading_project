package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static void main(String args[]) throws IOException
	{
		
		String src = "E:\\Excel Data Sheet\\Data1.xlsx";
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		System.out.println(sheet1);
		int rowcount = sheet1.getLastRowNum();
		System.out.println("Number of input data rows are :"+rowcount+1);
		
		for(int i =0 ; i <= rowcount ; i++)
		{
			for(int j = 0 ; j<= 1 ; j++)
			{
				System.out.print("Value is row "+i+"are "+sheet1.getRow(i).getCell(j).getStringCellValue());
				System.out.print("  ");
			}
			
			System.out.println();
		}
	}

}
