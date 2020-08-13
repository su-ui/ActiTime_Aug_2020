package com.actitime.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class invoke {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxProfile profile=new FirefoxProfile();
	    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
	    
	//  DesiredCapabilities cap = DesiredCapabilities.firefox();
	//	cap.setCapability(FirefoxDriver.PROFILE, profile);
		
	    FirefoxOptions options=new FirefoxOptions();
	    options.setProfile(profile);
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver(options);
		
		driver.get("https://www.selenium.dev/downloads/");
		
		driver.findElement(By.xpath("//td[text()='Java']/..//a[text()='Download']")).click();
		
		
		

	}

}
