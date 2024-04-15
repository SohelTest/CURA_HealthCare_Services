package exceldata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class lognegativedetails {

	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] readdata(String sheetname){
		FileInputStream file= null;
		
		try {
			file = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\CURA_Healtcare_Services\\src\\test\\java\\exceldata\\loginexcel.xlsx");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}catch(IOException a) {
			a.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++ ) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		return data;
		
	}
}
