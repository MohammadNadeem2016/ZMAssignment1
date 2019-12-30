/**
 * 
 */
package com.Pages;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.CommonUtilities.SeleniumMethods;

/**
 * @author $Mohammad_Nadeem$
 *
 */
public class FlipSearchList extends SeleniumMethods{
	
	WebDriver driver;
	String showPrice;

	
	By matchcall= By.xpath("//*[text()='Apple iPhone XR (Yellow, 64 GB)' and @class='_3wU53n']");
	By price= By.cssSelector("div[class='_1vC4OE _3qQ9m1']");
	
	/**
	 * Default Constructor.
	 * @param driver
	 */
	
	
	public FlipSearchList(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	/**
	 * This method will select the choice and give the result.
	 * 
	 */
	
	
	public void selectedList(String expected, String SWTitle) {
	
		String expectedText=expected;
		WebElement schoose=driver.findElement(matchcall);
		String actualText= schoose.getText();
			
		if(actualText.contentEquals(expectedText))
		{
			
			waitForButtonToBeClickable(schoose, driver);
			schoose.click();
		
			String maintitle= driver.getTitle();
			try {
			String mainWindow=driver.getWindowHandle();
				// It returns no. of windows opened by WebDriver and will return Set of Strings
			Set<String> set =driver.getWindowHandles();
				// Using Iterator to iterate with in windows
				Iterator<String> itr= set.iterator();
				while(itr.hasNext()){
					String childWindow=itr.next();
		// Compare whether the main windows is not equal to child window. If not equal, we will close.
					if(!mainWindow.equals(childWindow)){
						driver.switchTo().window(childWindow);
						
					String switchwindow= driver.getTitle();
					
					if(!maintitle.contentEquals(switchwindow)) {
						if(switchwindow.contains(SWTitle)) {
							
							WebElement currentPrice=driver.findElement(price);
							waitForElementToBeVisible(currentPrice, driver);
							String sPrice= currentPrice.getText().trim();
							System.out.println("Flipkart Apple iPhone XR (Yellow, 64 GB) Price= "+sPrice.substring(1));
							 showPrice= sPrice.substring(1);
						
									
						}
						
					}
					}}
			
		} catch (Exception e) {e.printStackTrace();}
			
				
		}
		
		else {
			
		System.out.println("Selective item that you want to search is not available in the present list");
		}
		
	}

	
	public int FComparison() {
		
		 
		 int len= showPrice.length();
		 String f="";
		 for(int i=0;i<len;i++) {
			
			 if(showPrice.charAt(i)==',') {
				 
			continue;	 
				 
			 }
			 
			 else if(showPrice.charAt(i)=='.') {
				 
				 break;
			 }
			
			f=f+showPrice.charAt(i); 
			 
		 }
		 
		int CheckNFShowPrice=Integer.parseInt(f);
		
		 return CheckNFShowPrice;
		 
		}
	
	
}



