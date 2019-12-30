/**
 * 
 */
package com.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.CommonUtilities.LaunchBrowser;
import com.Pages.BothComparison;
import com.Pages.FlipHomePage;
import com.Pages.FlipSearchList;
import com.Pages.HomePage;
import com.Pages.SearchList;



/**
 * @author $Mohammad_Nadeem$
 *
 */
public class HomePageTest extends LaunchBrowser {
	
	WebDriver driver;
	int AmazonPrice;
	int FlipkartPrice;
// Amazon Browser open
	@Test(priority=1)
	public void test() throws IOException, InterruptedException{
		
		driver = launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage homepage= new HomePage(driver);
		homepage.enterValueInSearchBoxField("Apple iPhone XR (64GB) - Yellow");
		homepage.clickOnSearchButton();
		Thread.sleep(1000);
		String expected="Apple iPhone XR (64GB) - Yellow";
		SearchList searchlist= new SearchList(driver); 
		searchlist.selectedList(expected);
		AmazonPrice= searchlist.AComparison();
		driver.quit();
		
		
	}
	
	
	// Flipkart Browser Open

	@Test(dependsOnMethods= {"test"})
	public void ftest() throws IOException, InterruptedException{
		
		driver = launchBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FlipHomePage homepage= new FlipHomePage(driver);
		homepage.enterValueInSearchBoxField("Apple iPhone XR (Yellow, 64GB)");
		homepage.clickOnSearchButton();
		Thread.sleep(1000);
		String expected="Apple iPhone XR (Yellow, 64 GB)";
		String SWTitle="Apple iPhone XR ( 64 GB Storage, 0 GB RAM )";
		FlipSearchList searchlist= new FlipSearchList(driver); 
		searchlist.selectedList(expected, SWTitle);
		FlipkartPrice= searchlist.FComparison();
		driver.quit();
		
	}
	
	
	
	
	  @AfterTest
	    public void bcompare() {
	    	
	    BothComparison bcomp= new BothComparison(AmazonPrice,FlipkartPrice);
	    	
	    	
	    }
		

}
