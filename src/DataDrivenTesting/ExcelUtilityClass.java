package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityClass {

	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	XSSFCell cell;

	// getting excel sheet into XSSFSheet object.
	public static void getXLSSheet(String filePath, String sheetName) {

		try {
			// getting excelFile
			FileInputStream fis = new FileInputStream(filePath);
			// getting it into POI WorkBook class
			wb = new XSSFWorkbook(fis);
			// getting the sheet
			sheet = wb.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// getting the start and the endpoint of test data
	public static XSSFCell[] getCellLimits(String tableName) {
		DataFormatter formatter = new DataFormatter();
		String pos = "begin";
		XSSFCell[] cellName = new XSSFCell[2];

		for (Row row : sheet) {
			for (Cell cell : row) {
				if (tableName.equals(formatter.formatCellValue(cell))) {
					if (pos.equals("begin")) {
						cellName[0] = (XSSFCell) cell;
						pos = "end";
					} else {
						cellName[1] = (XSSFCell) cell;
					}
				}
			}
		}
		return cellName;
	}

	// getting the test data between the start and the endpoint
	public static String[][] getTestData(String tableName) {
		DataFormatter formatter = new DataFormatter();
		String[][] testdata = null;

		XSSFCell[] cellBoundary = getCellLimits(tableName);

		XSSFCell startcell = cellBoundary[0];
		XSSFCell endCell = cellBoundary[1];

		int startRow = startcell.getRowIndex() + 1;
		int endRow = endCell.getRowIndex() - 1;
		int startCol = startcell.getColumnIndex() + 1;
		int endCol = endCell.getColumnIndex() - 1;
		
		testdata = new String[endRow -startRow + 1][endCol - startCol + 1];
		
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				testdata[i - startRow][j - startCol] = formatter.formatCellValue(cell);
			}
		}

		return testdata;
	}

}
