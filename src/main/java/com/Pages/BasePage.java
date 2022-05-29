package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	public WebDriver driver;
	
	//init driver:
	public WebDriver setUp(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\SeleniumWebDriver_With_MultiThreading\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prakash\\eclipse-workspace\\SeleniumWebDriver_With_MultiThreading\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
