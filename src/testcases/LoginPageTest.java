package com.actitime.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	TimeTrackPage timeTrackPage;
	
	
	public LoginPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException
	{
		initialization();
		
		 loginPage=new LoginPage();
	}
	//Validating the title
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login","Actual Title matching with expected");
	}
	
	
	//validating logo and product name
	@Test(priority=2)
	public void actiTimeLogoAndProdNameTest()
	{
		boolean logoPresent = loginPage.validateactiTimeLogo();
		Assert.assertTrue(logoPresent,"Logo is not Present");
		
		boolean prodNamePresent = loginPage.validateProdName();
		
		//Assert.assertTrue(prodNamePresent);
		
		Assert.assertTrue(prodNamePresent, "Yes, Product Name is not Present");
		
	}
	
	
	@Test(priority=4)
	public void forgotPwdLinkTest()
	{
		
		String forgotPwdText = loginPage.validateForgotPwdText();
		Assert.assertEquals(forgotPwdText, "Forgot your password?", "Text do not match");
		
		String forgotPwdLink = loginPage.validateForgotPwdLink();
		Assert.assertEquals(forgotPwdLink, "a","It is not a link");
	}
	
	
	@Test(priority=5)
	public void KeepMeLoggedInTest()
	{
		String keepMeLoggedInText = loginPage.validateKeepmeLoggedInText();
		
		Assert.assertEquals(keepMeLoggedInText, "Keep me logged in","Text do not match");
		
		String checkbox = loginPage.validateKeepmeLoggedIncheckBox();
		
		Assert.assertEquals(checkbox, "checkbox","It is not a checkbox");
		
	}
	
	@Test(priority=6)
	public void checkBoxTest()
	{
		boolean notSelected = loginPage.validateCheckBoxIsSelected();
		
		Assert.assertFalse(notSelected,"Checkbox is selected");
		
		loginPage.clikCheckBox();
		
		boolean selected = loginPage.validateCheckBoxIsSelected();
		
		Assert.assertTrue(selected,"checkbox not selected");
		
		}
	
	@Test(priority=7)
	public void copyRightTest()
	{
		String copyRightText = loginPage.validatecopyRight();
		
		Assert.assertEquals(copyRightText, "© actiTIME Inc.","No copyright");
		
		
		String CopyRightLink = loginPage.validateCopyRightLink();
		Assert.assertEquals(CopyRightLink, "a","It is not a link");
	}
	
	@Test(priority=8)
	public void versionTest()
	{
		String actiTimeVersion = loginPage.validateVersion();
		
		Assert.assertEquals(actiTimeVersion, "actiTIME 2020 Online","There is no version number");
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		try {
			timeTrackPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (FileNotFoundException e) {
		
		}
		
		
		String timeTrackPageTitle = timeTrackPage.validateTimeTrackPageTitle();
		
		
		
		Assert.assertEquals(timeTrackPageTitle, "actiTIME - Enter Time-Track","Title do not match");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
}
