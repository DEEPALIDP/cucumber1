package com.generic;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {

	private Pojo objpojo;
	
	private WebDriverWait wait;
	public WrapperFunctions(Pojo objpojo) {
		this.objpojo=objpojo;
	}
	
	//methods
	
	public void click(By locator)
	{
		objpojo.getDriver().findElement(locator).click();
		
	}
	public void setText(By locator, String str)
	{
		objpojo.getDriver().findElement(locator).sendKeys(str);
	}
	public String getText(By locator)
	{
		String value=objpojo.getDriver().findElement(locator).getText();
		return value;
	}
	
	public void waitforElements(By locator)
	{
		wait=new WebDriverWait(objpojo.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	       
	}
	
     
     public void waitForElemenClickable(By locator)
     {
    	 WebDriverWait wait = new WebDriverWait(objpojo.getDriver(), 40);
         wait.until(ExpectedConditions.elementToBeClickable(locator));
     }
           
     public void scrollDown(By locator)
     {
    	 JavascriptExecutor js = (JavascriptExecutor) objpojo.getDriver();  
    	 WebElement Element = objpojo.getDriver().findElement(locator);

         //This will scroll the page till the element is found		
         js.executeScript("arguments[0].scrollIntoView();", Element);
                    
     }
     public String selectRandom(By locator)
     {
    	 List<WebElement> list = objpojo.getDriver().findElements(locator);
         Random random = new Random();
         int num = random.nextInt(list.size());
         WebElement value = list.get(num);
         String str = value.getText();
         value.click();
         return str;    
       }
     
     public void Refresh()
     {
    	 objpojo.getDriver().navigate().refresh();
     }
     public int getPrimeNo()
     {
    	 int a[]={2, 3, 5, 7};
         Random r=new Random();
         int num=0;
         int rNo= r.nextInt(a.length-1);
         for (int i = 0; i < a.length; i++) {
             num=a[rNo];

         }
         return num;
     }
}
