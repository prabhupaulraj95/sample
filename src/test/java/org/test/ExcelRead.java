package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead
{
public static void main(String[] args) throws IOException
{
	File loc=new File("C:\\Users\\Prabhu\\eclipse-workspace\\MavenProject\\src\\test\\resources\\example.xlsx");
    FileInputStream fi=new FileInputStream(loc);
    Workbook w=new XSSFWorkbook(fi);
    Sheet s = w.getSheet("Sheet1");
    Row r = s.getRow(2);
    Cell cell = r.getCell(0);
    System.out.println(cell);
    //Row Count
    int totalrows = s.getPhysicalNumberOfRows();
    System.out.println(totalrows);
    //cell count
    int totalcells = r.getPhysicalNumberOfCells();
    System.out.println(totalcells);
    //get all values
    for(int i=0;i<s.getPhysicalNumberOfRows();i++)
    {
    	Row eachrow = s.getRow(i);
    	for(int j=0;j<eachrow.getPhysicalNumberOfCells();j++)
    	{
    		Cell eachcell = eachrow.getCell(j);
    		System.out.println(eachcell);
    	}
    }
    




}
}
