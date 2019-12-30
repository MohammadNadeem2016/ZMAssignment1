/**
 * 
 */
package com.CommonUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author $Mohammad_Nadeem$
 *
 */
public class ReadConfigFile {
	
	
		
		public Properties readConfigData() throws IOException{
			String classPath = System.getProperty("user.dir");
			File file = new File(classPath+"/src/config.properties");
			FileInputStream fileInputStream =  new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties;
		}

	}

	
	
	


