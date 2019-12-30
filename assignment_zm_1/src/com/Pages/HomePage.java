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
public class HomePage extends SeleniumMethods  {
	
		WebDriver driver;
		
		
		By searchBox= By.id("twotabsearchtextbox");
		By submit= By.xpath("(//*[@class='nav-input'])[1]");
		
		
		/**
		 * Default Constructor.
		 * @param driver
		 */
		
		public HomePage(WebDriver driver) {
			this.driver = driver;

		}
		
		/**
		 * This method will enter value in Search Box text field.
		 * @param Fill
		 */
		public void enterValueInSearchBoxField(String fill){
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









