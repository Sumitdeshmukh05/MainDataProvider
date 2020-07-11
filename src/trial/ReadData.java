package trial;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData
{
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ReadData(String ExcelPath)
	{
		
			try
			{
				File src = new File(ExcelPath);
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			}
			
			catch(Exception e)
			{
				
			}
		
	}
		
	public int GetCountofRows(String SheetName)
	{
		sheet = wb.getSheet(SheetName);
		int row = sheet.getLastRowNum();
		row = row+1;
		return row;
	}

	public String ReadCellData(String SheetName, int row, int column)
	{
		sheet = wb.getSheet(SheetName);
		String Data = sheet.getRow(row).getCell(column).getStringCellValue();
		return Data;
	
	}
	

}
