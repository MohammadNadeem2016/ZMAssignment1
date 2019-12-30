/**
 * 
 */
package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.CommonUtilities.SeleniumMethods;

/**
 * @author $Mohammad_Nadeem$
 *
 */
public class FlipHomePage extends SeleniumMethods {
	
	
	WebDriver driver;
	
	By popcross= By.xpath("//*[@class='_2AkmmA _29YdH8']");
	By searchBox= By.xpath("//*[@class='LM6RPg' and @name='q']");
	By submit= By.xpath("//*[@class='vh79eN' and @type='submit']");
	
	
	/**
	 * Default Constructor.
	 * @param driver
	 */
	
	public FlipHomePage(WebDriver driver) {
		this.driver = driver;

	}
	
	/**
	 * This method will enter value in Search Box text field.
	 * @param Fill
	 */
	public void enterValueInSearchBoxField(String fill){
		driver.findElement(popcross).click();
		WebElement sbox= driver.findElement(searchBox);
		waitForElementToBeVisible(sbox, driver);
		sbox.clear();
		sbox.sendKeys(fill);
	}
	
	/**
	 * This method will click on Search button.
	 */


	public void clickOnSearchButton() {
		
		WebElement sub= driver.findElement(submit);
		waitForButtonToBeClickable(sub, driver);
		sub.click();
		
	}
	
	
	

}
