package com.generic;

import org.openqa.selenium.WebDriver;

public class Pojo {
	private static WebDriver driver;
	WrapperFunctions objWrapperFunction;
	Xlsx_Read objxlsread;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	public void setDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WrapperFunctions getWrapper()
	{
		return objWrapperFunction;
	}
	public void setWrapper(WrapperFunctions objWrapperFunction){
		this.objWrapperFunction=objWrapperFunction;
	}
	public Xlsx_Read getxlsRead()
	{
		return objxlsread;
	}
	public void setXlsRead(Xlsx_Read objxlsread)
	{
		this.objxlsread=objxlsread;
	}
}
