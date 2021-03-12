package com.smallProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	Properties prop;
	
	public ReadProperties(){
		
		try {
			FileInputStream fil = new FileInputStream(new File("./src/test/java/com/smallProject/testData/testData.properties"));
			prop = new Properties();
			prop.load(fil);
		} catch (FileNotFoundException e) {
			System.out.println("Exception is " + e.getMessage());
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String getBrowserName() {
		return prop.getProperty("browserName");
	}
	
	public String getBasedUrl() {
		return prop.getProperty("basedUrl");
	}
	
	public String getUserName() {
		return prop.getProperty("userName");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
}
