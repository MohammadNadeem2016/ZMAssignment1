/**
 * 
 */
package com.CommonUtilities;

import java.io.IOException;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author $Mohammad_Nadeem$
 *
 */
public class LaunchBrowser extends ReadConfigFile {
	
	
	/*              Launch Browser           */

		WebDriver driver;

		/**
		 * This method will launch the browser and hit URL.
		 * 
		 * @return: driver object.
		 * @throws IOException
		 */
		public WebDriver launchBrowser() throws IOException {
			String Browser = readConfigData().getProperty("Browser");
			if (Browser.equals("Chrome")) {
				String classPath = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver", classPath+"/src/chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setAcceptInsecureCerts(true);
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
				driver = new ChromeDriver(chromeOptions);
			} else if (Browser.equals("IE")) {
				String classPath = System.getProperty("user.dir");
				System.setProperty("webdriver.ie.driver", classPath+"/src/IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
				capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(capabilities);
			} else if (Browser.equals("firefox")) {
				// Code to launch Firefox browser
			}
			
			
			return driver;
		}

	}

	
	
	
	/*                    END Launch Browser                 */


