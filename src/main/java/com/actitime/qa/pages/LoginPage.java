package com.actitime.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	
   
	@FindBy(name="username")
    WebElement username;
    
    @FindBy(name="pwd")
    WebElement password;
    
    @FindBy(xpath="//div[text()='Login ']")
    WebElement loginBtn;
    
    @FindBy(xpath="//div[@class='atLogoImg']")
    WebElement actiTimeLogo;
    
    
    @FindBy(xpath="//div[@class='atProductName']")
    WebElement prodName;
    
    @FindBy(id="toPasswordRecoveryPageLink")
    WebElement forgotPwd;
    
    @FindBy(id="keepMeLoggedInSection")
    WebElement keepmeLoggedIn;
    
    @FindBy(xpath="//nobr[text()='actiTIME 2020 Online']")
    WebElement version;
    
    
    @FindBy(id="keepLoggedInCheckBox")
    WebElement checkBox;
    
    @FindBy(xpath="//*[contains(text(),'© ')]")
    WebElement copyRight;
    
    @FindBy(xpath="//a[@href='http://www.actitime.com']")
    WebElement copyRightLink;
    
    
    @FindBy(id="keepLoggedInCheckBox")
    WebElement selectCheckBox;
    
   
    public LoginPage() throws FileNotFoundException {
    	PageFactory.initElements(driver, this);
	}
    
    public String validateLoginPageTitle()
    {
    	return driver.getTitle();
    }

    
    public boolean validateProdName()
    {
    	return prodName.isDisplayed();
    }
  
    
    public boolean validateactiTimeLogo()
    {
    	return actiTimeLogo.isDisplayed();
    }
    
    public TimeTrackPage login(String un,String pwd) throws FileNotFoundException
    {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	
    	WebDriverWait wait=new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.titleContains("actiTIME - Enter Time-Track"));
    	
    	
    	return new TimeTrackPage();
    }
    
    public String validateForgotPwdText()
    {
    	return forgotPwd.getText();
    	
    }
    
    public String validateForgotPwdLink()
    {
    	return forgotPwd.getTagName();
    	
    }
    
    
    
    
    
    public String validateKeepmeLoggedInText()
    {
    	return keepmeLoggedIn.getText();
    }
    
    public String validateKeepmeLoggedIncheckBox()
    {
    	return checkBox.getAttribute("type");
    }
    
    public boolean validateCheckBoxIsSelected()
    {
    	return selectCheckBox.isSelected();
    }
    
    public void clikCheckBox()
    {
    	selectCheckBox.click();
    	
    }
    
    public String validateVersion()
    {
    	return version.getText();
    }
    
   
    
    
    public String validatecopyRight()
    {
    	return copyRight.getText();
    			
    }
    
    
    public String validateCopyRightLink()
    {
    	return copyRightLink.getTagName();
    }
    
	
    }

