
package com.actitime.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.util.TestUtil;

public class TimeTrackTest extends TestBase {

	LoginPage loginPage;
	TimeTrackPage timeTrackPage;

	public TimeTrackTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialization();

		loginPage = new LoginPage();

		timeTrackPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test()
	public void TimeTrackePageTitleTest() {
		String timeTrackPageTitle = timeTrackPage.validateTimeTrackPageTitle();
		Assert.assertEquals(timeTrackPageTitle, "actiTIME - Enter Time-Track",
				"Actual Title not matching with expected");
	}

	@Test(priority = 2)
	public void createNewTaskTest() throws InterruptedException {
		timeTrackPage.clickNewTask();
		timeTrackPage.setNewCustomer();
		timeTrackPage.enterCustomerName("Ranga");
		timeTrackPage.enterProjectName("RedDragon");

		timeTrackPage.enterFirstTaskName("HouseKeeping");
		timeTrackPage.selectTypeOfWork();
		timeTrackPage.clickCreateTaskBtn();

		Thread.sleep(2000);
		
		try {
			TestUtil.screenshotWithDate(prop.getProperty("browser"), "createNewTaskTest");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timeTrackPage.clickPatluNewUser();

	}

	@AfterMethod()
	public void tearDown() {
		driver.close();

	}

}
