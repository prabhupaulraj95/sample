package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelType {
	public static void main(String[] args) throws IOException {
		File loc=new File("C:\\Users\\Prabhu\\eclipse-workspace\\MavenProject\\src\\test\\resources\\example.xlsx");
	    FileInputStream fi=new FileInputStream(loc);
	    Workbook w=new XSSFWorkbook(fi);
	    Sheet s = w.getSheet("Sheet1");
	    Row r = s.getRow(1);
	    Cell cell = r.getCell(3);
	    System.out.println(cell);
	   int cellType = cell.getCellType();
	   System.out.println(cellType);
	   //type 1----string type 0---numbers,dates
	   if(cellType==1)
	   {
		   String value = cell.getStringCellValue();
		   System.out.println(value);
	   }
	   else {
		   if(DateUtil.isCellDateFormatted(cell))
		   {
			   Date d = cell.getDateCellValue();
			   SimpleDateFormat si=new SimpleDateFormat("dd-MMM-yyyy");
			   String value = si.format(d);
			   System.out.println(value);
		   }
		   else
		   {
			   double numericCellValue = cell.getNumericCellValue();
			   long l=(long)numericCellValue;
			   String value = String.valueOf(l);
			   System.out.println(value);
		   }
	   }
	}

}
