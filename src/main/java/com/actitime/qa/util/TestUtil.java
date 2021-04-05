package com.actitime.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.actitime.qa.base.TestBase;

public   class TestUtil extends TestBase{
	
	public TestUtil() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static Date d = new Date();
	//returning the actual date
	public static String currentDate = d.toString().replaceAll(":", "_");

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
	
	public static void screenshotWithDate( String browserName,String methodName) throws IOException {
		
		
		//Typecasting the driver object to TakesScreenshot interface type.
		TakesScreenshot ts = (TakesScreenshot) driver;
		//getting the source file and storing in a file
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		/*Created a folder called "Screenshot" under the folder "Results" in the project directory
		Created another file by concatenating the date value  which has "_" in it
		(Underscore is the accepted character while creating a file in the project )*/
		File destFile = new File(".//Results//"+"_"+browserName+"_"+methodName+"_"+currentDate+".png");
		//storing the screenshot in the destination location
		FileUtils.copyFile(srcFile, destFile);
	}
	
	
	

}

