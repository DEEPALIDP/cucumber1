package com.script;

import java.io.IOException;

import org.automationtesting.excelreport.Xl;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pages.HomePage;

public class BookmyShowTest extends BaseTest {
	private HomePage objHomePage;
	
	public void initilalizeViewAndPages()
	{
		objHomePage=new HomePage(this);
	}
	
	
	@BeforeTest
	public void InitialSetUp()
	{
		this.initializeBrowserSetup();
		this.initilalizeViewAndPages();
	}
	@Test
	public void HomePageTest() throws IOException
	{
		objHomePage.clickOnHomePagePopUpNotNow();
		objHomePage.selectHomePagePopCity();
		objHomePage.clickHomePageOnMovieslink();
		objHomePage.selectHomePageRandomLanguage();
		objHomePage.selectHomePageRandomMovie();
		objHomePage.getCastName();
		//objHomePage.clickOnHomePageBookTicketButton();
		objHomePage.selectOnHomePageRandomDate();
		objHomePage.getOnHomePageMovieTitle();
		objHomePage.selectOnHomePageRandomTime();
		objHomePage.clickOnHomePageAcceptButton();
		objHomePage.selectOnHomePageSeatsNumber();
		objHomePage.clickOnHomeSelectmSeatsButton();
		objHomePage.clickOnHomePageSelectSeatsofTheater();
		objHomePage.clickOnHomePageMTicketsRadioButton1();
		
	}
	@AfterSuite
	public void generateReport() throws Exception {
		Xl.generateReport("Report-xml.xlsx");
	}
	
}
