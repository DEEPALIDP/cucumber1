package com.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.generic.Pojo;
import com.generic.WrapperFunctions;

public class HomePage {
	
	private static final String Time = null;
	private Pojo objPojo;
	private String selMovie;
	private WrapperFunctions objWrapper;
	String n;
	public HomePage(Pojo objpojo) {
		// TODO Auto-generated constructor stub
		this.objPojo=objpojo;
		
	}

	
	//locators
	By popup =By.xpath("//button[@id='wzrk-cancel']");
	By inpCity= By.xpath("//ul[@class='sc-iybRtq fYDbAn']/child::li");
	By lnkMovies = By.linkText("Movies");
	By selectCity =By.xpath("(//div[@class='sc-kkGfuU aegkT'])[1]//span[@class='sc-gipzik jyyMA ellipsis']");
	By selectlanguage= By.xpath("//div[@class='style__StyledText-tgsgks-0 cAIFpf']");
    By selectmovie =By.xpath("//div[@class='style__StyledText-tgsgks-0 gbzvvd']");
    By cast= By.xpath("//h4[text()='Cast']/parent::div/parent::div/following-sibling::div//div//a");
    By btnBookTickets =By.xpath("//button//span[text()='Book tickets']");
    By date= By.xpath("//div[@class='date-day']");
    By movieTitle = By.xpath("//h1//div//a");
    By time =By.xpath("//div[@class='showtime-pill-container']");   
    By btnAcceptPopUp = By.xpath("//a[@id='btnPopupAccept']");
    By btnSelectSeats=By.xpath("//div[@id='proceed-Qty']");
    By selectNumbers=By.xpath("//ul[@id='popQty']/child::li");
	By seats = By.xpath("//div[@id='seatcall']");
	By twoDPopUP=By.xpath("(//div[@class='styles__DimensionComponent-sc-1efo077-3 ifVrUL'])[1]");
	By seatNumber = By.xpath("//span[@id='intQty']");
	By btnpayButton = By.xpath("//div[@class='__seat-action']//a[@id='btmcntbook']");
	By selectAvailableSeats=By.xpath("//a[@class='_available']");
	By rdmtickets = By.xpath("//label[@for='mticket']");
	//By rdmTickets = By.xpath("//div[@id='TickType']//div[@id='shmticket']");
	By btnProceed = By.xpath("//a[@id='prePay']");
	
    //Handle Pop up
	public void clickOnHomePagePopUpNotNow(){
		objPojo.getWrapper().waitforElements(popup);
		objPojo.getWrapper().click(popup);
	}
	
    //Select random City
    public void selectHomePagePopCity() {
    	objPojo.getWrapper().waitforElements(inpCity);
    	String selCity=objPojo.getWrapper().selectRandom(inpCity);
    	System.out.println("Selected City="+selCity);
    	if(selCity.equals("Kochi"))
    	{
    		objPojo.getWrapper().waitforElements(selectCity);
    		objPojo.getWrapper().click(selectCity);
    		objPojo.getWrapper().selectRandom(inpCity);
    	}

    }

    //Select  Movies Link
    public void clickHomePageOnMovieslink() {
    	try {
    		objPojo.getWrapper().waitforElements(lnkMovies);
            objPojo.getWrapper().click(lnkMovies);
            System.out.println("Click On Movies Link");

		} catch (Exception e) {
			System.out.println(e);
		}
    	    }

    //Select random Language
    public void selectHomePageRandomLanguage() {
    	try {
    			objPojo.getWrapper().waitforElements(selectlanguage);
    			String language=objPojo.getWrapper().selectRandom(selectlanguage);
    			System.out.println("Selected language is="+language);

			
		} catch (Exception e) {
			System.out.println(e);
		}
    	    }
    

    //Select Random Movie
    public void selectHomePageRandomMovie() {
    	try {
    		objPojo.getWrapper().Refresh();
        	objPojo.getWrapper().waitForElemenClickable(selectmovie);
        	selMovie = objPojo.getWrapper().selectRandom(selectmovie);
           System.out.println("Select Movie");

    	} catch (Exception e) {
    		System.out.println(e);		}
    	
    }

    //Get cast names
    public void getCastName() throws IOException{
    	
    	objPojo.getWrapper().waitforElements(cast);
        FileWriter fw = null;
        try{
        	 List<WebElement> locator = objPojo.getDriver().findElements(cast);
             for (int i = 0; i < locator.size(); i++) {
                 String castName = locator.get(i).getText();
                 System.out.println(castName);
                 fw =new FileWriter("./target/ActorName.txt",true);    
                 fw.write(castName+"\n");   
             
             }
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
       finally
       {
    	   objPojo.getWrapper().click(btnBookTickets);
    	   System.out.println("Click on Book Tickets Button");
       }
        
    }

    //Click on Book Ticket Button
  /*  public void clickOnHomePageBookTicketButton() {
    	
    objPojo.getDriver().findElement(btnBookTickets).click();	
        
    }*/
    
    //Select Random Day
    public void selectOnHomePageRandomDate(){
    	try
    	{
    		WebElement popUp2D= objPojo.getDriver().findElement(twoDPopUP);
    		if(popUp2D.isDisplayed())
    			{
    				objPojo.getWrapper().waitforElements(twoDPopUP);
    				objPojo.getWrapper().selectRandom(twoDPopUP);
    			}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	finally
    	{
    		objPojo.getWrapper().waitforElements(date);
            objPojo.getWrapper().selectRandom(date);
            System.out.println("Select date");
    	}
    	
      
    }
    //Verify movie Title
    public void getOnHomePageMovieTitle() {
    	try {
    		String title=objPojo.getWrapper().getText(movieTitle);
            // = objPojo.getDriver().findElement(movieTitle).getText();
            String actualTitle = title.trim();
            System.out.println("Movie name="+actualTitle);
            Assert.assertEquals(selMovie, actualTitle);
			
		} catch (Exception e) {
			System.out.println(e);		}
    	    
    }
    //Select Random time
    public void selectOnHomePageRandomTime()
    {   try {
    	objPojo.getWrapper().selectRandom(time);
    	System.out.println("Select time");
	} catch (Exception e) {
			System.out.println(e);	
		}
    }
    //Click On Accept button
    public void clickOnHomePageAcceptButton()
    {
    	try {
        		objPojo.getWrapper().click(btnAcceptPopUp);
        		System.err.println("Click On Accept buttom");
		} catch (Exception e) {
			System.out.println(e);		}
    }
    //select SeatNumber
    public void selectOnHomePageSeatsNumber()
    {
    	try {
    		objPojo.getWrapper().waitforElements(selectNumbers);
        	objPojo.getWrapper().selectRandom(selectNumbers);
        	System.out.println("Select random no");

		} catch (Exception e) {
			System.out.println(e);		
		}
     }
    //ClickSelectButton
    public void clickOnHomeSelectmSeatsButton(){
    	try {
        	objPojo.getWrapper().click(btnSelectSeats);
        	System.out.println("Select Select seats button");
			
		} catch (Exception e) {
			System.out.println(e);		}
    	
    }
    
    public void clickOnHomePageSelectSeatsofTheater(){
    	String str=objPojo.getWrapper().getText(seatNumber);
    	int number=Integer.parseInt(str);
    	System.out.println(number);
    	for(int i=0;i<number;i++){
    		try{
    				objPojo.getWrapper().waitForElemenClickable(selectAvailableSeats);
    				 multipleTimesClick();
    				 objPojo.getWrapper().click(btnpayButton);
    				 System.out.println("Click on Pay Button");
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}
    		
    	}
    	
    
    }

   
    public void multipleTimesClick(){
        boolean flag = objPojo.getDriver().findElement(btnpayButton).isDisplayed();
        while(flag==false){
           By locator = By.xpath("//a[@class='_available']");
            objPojo.getWrapper().click(locator);
        	//JavascriptExecutor js=(JavascriptExecutor)objPojo.getDriver();
        	//js.executeScript("arguments[0].click()", locator);
            boolean flag2 = objPojo.getDriver().findElement(btnpayButton).isDisplayed();
            flag=flag2;
        }
    }
     public void clickOnHomePageMTicketsRadioButton()
     {
    	 //objPojo.getWrapper().waitForElemenClickable(rdmTickets);
    	// objPojo.getWrapper().scrollDown();
    	 
    	     	 
    	 WebElement mtickets =objPojo.getDriver().findElement(rdmtickets);
    	 if(mtickets.isDisplayed())
    	 {
    		 objPojo.getWrapper().waitforElements(rdmtickets);

    		 objPojo.getWrapper().click(rdmtickets);
    	 }
    	 else
    	 {
    		 
    		objPojo.getWrapper().click(btnProceed); 
    	 }
    	 
     }
     
     
     public void clickOnHomePageMTicketsRadioButton1()
     {
    	 //objPojo.getWrapper().waitForElemenClickable(rdmTickets);
    	 //objPojo.getWrapper().scrollDown(rdmtickets);
    	 //System.out.println();
    	  try{   	 
    	 WebElement mtickets =objPojo.getDriver().findElement(rdmtickets);
    	 if(mtickets.isDisplayed())
    	 {
    		 objPojo.getWrapper().waitforElements(rdmtickets);
    		 objPojo.getWrapper().click(rdmtickets);
    	 }
     }
    	  catch(Exception e)
    	  {
    		  System.out.println(e);
    	  }
     
    	  finally
    	  {
    		  objPojo.getWrapper().waitForElemenClickable(btnProceed);
    		  objPojo.getWrapper().click(btnProceed);

    	  }
     }
     
     public void SelectPrimeSeatNumber()
     { 
        // objPojo.getWrapper().waitforvisibileelement();
         int seatNo=objPojo.getWrapper().getPrimeNo();
         By locator = By.xpath("//li[@id='pop_"+seatNo+"']");
         objPojo.getWrapper().click(selectAvailableSeats);
         
         objPojo.getWrapper().click(selectAvailableSeats);
         objPojo.getWrapper().selectRandom(selectAvailableSeats);
           String s = objPojo.getDriver().findElement(selectAvailableSeats).getText();
           int num = Integer.parseInt(s);
           System.out.println(num);
           for(int i=0;i<=num-1;i++)
           {              
           objPojo.getDriver().findElement(selectAvailableSeats).click();;
           }
     }
  
   
}

