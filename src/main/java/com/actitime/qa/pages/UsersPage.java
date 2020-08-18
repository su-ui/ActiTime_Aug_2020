package com.actitime.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.util.TestUtil;

public class UsersPage extends TestBase{
	
	
	
	@FindBy(id="container_users")
	WebElement usersTab;
	
	@FindBy(xpath="//span[text()='List of Users']")
	WebElement listOfUsers;
	
	@FindBy(xpath="//div[text()='New User']")
	WebElement newUser;
	
	@FindBy(xpath="//div[text()='Add User']")
	WebElement addUserPage;
	
	@FindBy(id="createUserPanel_firstNameField")
	WebElement firstName;
	
	@FindBy(id="createUserPanel_lastNameField")
	WebElement lastName;
	
	@FindBy(id="createUserPanel_emailField")
	WebElement emailAddress;
	
	@FindBy(xpath="//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']")
	WebElement departmentDropdown;
	
	//@FindBy(xpath="//div[@class='itemsContainer']//div[text()='Quality Control']")
	//WebElement selectDropDown;
	
	@FindBy(xpath="//div[@class='item']")
	WebElement selectDptOptions;
	

	public UsersPage() throws FileNotFoundException {
		//super();
		PageFactory.initElements(driver, this);
	}
	
	public String titleOfUsersPage()
	{
		return driver.getTitle();
	}
	
	public void clickUserPage()
	{
		usersTab.click();
		
        WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(listOfUsers));
	}
	
	public void clickNewUserBtn()
	{
		newUser.click();
		
		 WebDriverWait wait=new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOf( addUserPage));
		
		
	}
	
	
	public void createNewUser(String sheet) throws InvalidFormatException, IOException, InterruptedException
	{
		
		
		FileInputStream fis=new FileInputStream("./UserDetails/userdetails.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		           Sheet sh= wb.getSheet(sheet);
		           
		  for(int i=1;i<=sh.getLastRowNum();i++)
	   		{
	   			String firstn = wb.getSheet(sheet).getRow(i).getCell(0).toString();
	   		 firstName.sendKeys(firstn); 
	   			 String lastn = wb.getSheet(sheet).getRow(i).getCell(1).toString();
	   			 lastName.sendKeys(lastn);
	   			String emailid= wb.getSheet(sheet).getRow(i).getCell(2).toString();
	   			
	   			emailAddress.sendKeys(emailid);
	   			
	   		//	WebDriverWait wait=new WebDriverWait(driver,20);
	   		//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[text()='Time-Track Approval Settings'])[1]"))));
	   			
	   		}
		  
		 
		  
	   		      
	 }
	
	
	public void selectDptDropdown(String selectDpt) throws InterruptedException
	
	
	{
	    departmentDropdown.click();
		
		//driver.findElement(By.xpath("//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']")).click();
		Thread.sleep(2000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='item']"));
		
		for(WebElement ele:elements)
		{
			if(ele.getText().contains(selectDpt))
			{
				ele.click();
			}
		}
	}
	
	
	

}
