package com.actitime.qa.testcases;

import java.io.FileNotFoundException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.pages.UsersPage;

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
		 
		 usersPage=new UsersPage();
		 
		 usersPage.clickUserPage();
		 
		 String title = usersPage.titleOfUsersPage();
		 
		 Assert.assertEquals(title, "actiTIME - User List","title do not match");
	
		 
		 
		 
	}
	
	@Test
	public void clickAddNewUserTest()
	{
		usersPage.clickNewUserBtn();
		usersPage.enterUserDetails("Sur","Mur", "supri.mce@gmail.com");
		usersPage.selectDptDropdown("Quality Control");
	}
	
	
	

}

