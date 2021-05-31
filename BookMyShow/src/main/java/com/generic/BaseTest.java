package com.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.automationtesting.excelreport.Xl;
public class BaseTest extends Pojo {

	
	public void initializeBrowserSetup()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		setDriver(new ChromeDriver());
		getDriver().get("https://in.bookmyshow.com/");
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		objWrapperFunction = new WrapperFunctions(this);
		
		
	}
	
}
