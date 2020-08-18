package com.actitime.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static void setUserDetails(String sheet,int colnum) throws InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Samsu\\Desktop\\userdetails.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		           Sheet sh= wb.getSheet(sheet);
		           
		           
		           for(int i=0;i<=sh.getLastRowNum();i++)
		   		{
		   			String firstn = wb.getSheet(sheet).getRow(i).getCell(colnum).toString();
		   			 String lastn = wb.getSheet(sheet).getRow(i).getCell(colnum).toString();
		   			String emailid= wb.getSheet(sheet).getRow(i).getCell(colnum).toString();
		   		      
		           
		   			
		   			
		           
		           
		           
				//   Row rowVal=sh.getRow(rownum);
				//  Cell colVal=  rowVal.getCell(colnum);
				  //   String value = colVal.toString();
				  //   return value;
				  
				  
	}

}
}
