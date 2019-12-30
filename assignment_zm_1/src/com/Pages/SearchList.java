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
public class SearchList extends SeleniumMethods{
	
	WebDriver driver;
	String showPrice;

	
	By matchcall= By.xpath("//*[text()='Apple iPhone XR (64GB) - Yellow' and @class='a-size-medium a-color-base a-text-normal']");
	By price= By.id("priceblock_ourprice");
	
	
	/**
	 * Default Constructor.
	 * @param driver
	 */
	
	
	public SearchList(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	

	/**
	 * This method will select the choice and give the result.
	 * @throws InterruptedException 
	 * 
	 */
	
	
	public void selectedList(String expected) throws InterruptedException {
	
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
						if(switchwindow.contains(expectedText)) {
							
							WebElement currentPrice=driver.findElement(price);
							waitForElementToBeVisible(currentPrice, driver);
							String sPrice= currentPrice.getText().trim();
							System.out.println("Amazon Apple iPhone XR (Yellow, 64 GB) Price= "+sPrice.substring(2));
							showPrice= sPrice.substring(2);
						
						
					
						}
						
					}
					}}
			
		} catch (Exception e) {e.printStackTrace();}
				
		}
		
		else {
			
		System.out.println("Selective item that you want to search is not available in the present list");
		}
			
		
	}
	
	
	public int AComparison() {
		
		 int len= showPrice.length();
		 String a="";
		 for(int i=0;i<len;i++) {
			
			 if(showPrice.charAt(i)==',') {
				 
			continue;	 
				 
			 }
			 
			 else if(showPrice.charAt(i)=='.') {
				 
				 break;
			 }
			
			a=a+showPrice.charAt(i); 
			 
		 }
		int CheckNAShowPrice=Integer.parseInt(a);
		
		return CheckNAShowPrice;
		
	}
	
	
}








