package com.actitime.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

public class UsersPageTest extends TestBase{
	
	LoginPage loginPage;
	TimeTrackPage timeTrackPage;
	UsersPage usersPage;

	public UsersPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException
	{
		initialization();
		
		 loginPage=new LoginPage();
		 
		 timeTrackPage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 
		usersPage= timeTrackPage.goToUsersPage();
		 
		 String title = usersPage.titleOfUsersPage();
	 
		 Assert.assertEquals(title, "actiTIME - User List","title do not match");
	
		 }
	
	@Test
	public void createNewUserTest() throws InvalidFormatException, IOException, InterruptedException
	{
		usersPage.clickNewUserBtn();
		usersPage.createNewUser("Sheet1");
		
		Thread.sleep(1000);
		
	
		//usersPage.selectDropDownItem("Sales & Support");
		
		usersPage.clickSendIvitation();
		
		TestUtil.screenshotWithDate( prop.getProperty("browser"),"createNewUserTest");
		
		String text = usersPage.textOftheConfirmationMsg();
		
		Assert.assertEquals(text, "Invite one more user","Text of confirmation page doesnt match, verify");
		
		usersPage.clickCloseBtn();
		
     }
	
	@AfterMethod()
	public void tearDown()
	{
		driver.close();
		
	}
	

	
	
	

}

