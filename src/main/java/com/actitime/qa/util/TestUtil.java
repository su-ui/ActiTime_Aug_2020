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
	
	public static Workbook wb;
	public static FileInputStream fis;
	
	public static void setUserDetails(String sheet) throws InvalidFormatException, IOException
	{
		 fis=new FileInputStream("./UserDetails/userdetails.xlsx");
		 wb=WorkbookFactory.create(fis);
		           Sheet sh= wb.getSheet(sheet);
		           
		          
	}

}

