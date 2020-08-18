package com.actitime.qa.pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;

public class TimeTrackPage extends TestBase{
	
	
	@FindBy(id="addTaskButtonId")
	WebElement newTask;
	
	@FindBy(xpath="//tr[@class='selectCustomerRow']//div[@class='comboboxButton']")
	WebElement customerDropDown;
	
	
	@FindBy(xpath="//div[text()='- New Customer -']")
	WebElement selectCustomer;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@placeholder='Enter Project Name']")
	WebElement projectName;
	
	
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[1]")
	WebElement fisrtTaskName;
	
	@FindBy(xpath="(//button[text()='set deadline'])[1]")
	WebElement setDeadline;
	
	@FindBy(xpath="(//td[@class='billingTypeCell']//div[@class='typeOfWorkButton editable'])[1]")
	WebElement typeOfWork;
	
	@FindBy(xpath="(//div[text()='management'])[1]")
    WebElement selectTypeOfWork;
	
	@FindBy(xpath="//div[text()='Create Tasks']")
	WebElement createTaskBtn;
	
	@FindBy(xpath="//div[text()='Users']")
	WebElement usersTab;
	
	
	

	public TimeTrackPage() throws FileNotFoundException {
		//super();
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String validateTimeTrackPageTitle()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.titleContains("actiTIME - Enter Time-Track"));
		return driver.getTitle();
	}
	
	
	public void clickNewTask()
	{
		newTask.click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(customerDropDown));
		
		
	}
	
	public void setNewCustomer() throws InterruptedException
	{
		customerDropDown.click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='                Create New Tasks            ']"))));
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("//div[text()='- New Customer -']"));
		
		int x = ele.getLocation().getX();
		
		int y = ele.getLocation().getY();
		
		js.executeScript("window.scrollTo("+x+","+y+")");
		js.executeScript("arguments[0].click()", ele);
		
		
		
		
		
		
		Actions action=new Actions(driver);
		action.moveToElement(selectCustomer).build().perform();
		selectCustomer.click();
		
		
		
List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'itemRow ')]"));


		
	/*	for(WebElement ele:elements)
		{
			Thread.sleep(1000);
			System.out.println(ele.getText());
			
			if(ele.getText().contains("New Customer"))
			{
				ele.click();
				break;
			}
		}*/
		
		
	}
	
	public void enterCustomerName(String cnn)
	{
		customerName.sendKeys(cnn);
	}
	
	public void enterProjectName(String pn)
	{
		projectName.sendKeys(pn);
	}
	
	public void enterFirstTaskName(String tn)
	{
		fisrtTaskName.sendKeys(tn);
	}
	
	public void selectTypeOfWork()
	{
		typeOfWork.click();
		
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOf(selectTypeOfWork));
		
		
		List<WebElement> Elements = driver.findElements(By.xpath("//div[@class='typeOfWorkRow']"));
		
		for(WebElement elem:Elements)
		{
			String text = elem.getText();
			System.out.println(text);
			if(elem.getText().contains("management"))
			{
				elem.click();
				break;
				
			}
		}
		
	}
	
	public void clickCreateTaskBtn()
	{
		createTaskBtn.click();
		
	
	}
	
	public UsersPage goToUsersPage() throws FileNotFoundException
	{
		usersTab.click();
		
		return new UsersPage();
	}
	
	
	
	

	

}
