package com.actitime.qa.pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;

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
	
	@FindBy(xpath="//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty active']")
	WebElement departmentDropdown;
	
	@FindBy(xpath="//div[@class='itemsContainer']//div[text()='Quality Control']")
	WebElement selectDropDown;
	
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
	
	public void enterUserDetails(String fn,String ln,String emailadd)
	{
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailAddress.sendKeys(emailadd);
		
		
	}
	
	public void selectDptDropdown(String selectDpt)
	{
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
