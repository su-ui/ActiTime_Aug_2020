package com.actitime.qa.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class trykey  {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='New']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tr[@class='selectCustomerRow']//div[@class='comboboxButton']")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'itemRow ')]"));
		
		for(WebElement ele:elements)
		{
			Thread.sleep(1000);
			System.out.println(ele.getText());
			
			if(ele.getText().contains("New Customer"))
			{
				ele.click();
				break;
			}
		}
		
		
	}

}
