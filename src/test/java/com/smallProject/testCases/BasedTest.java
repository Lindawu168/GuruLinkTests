package com.smallProject.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.smallProject.utilities.DriverConfigures;
import com.smallProject.utilities.ReadProperties;

public class BasedTest{
	public static WebDriver driver;
	public Logger logger;
	ReadProperties rp = new ReadProperties();

	@BeforeClass
	public void setUp() throws InterruptedException, IOException {
		driver= DriverConfigures.getDriver();
		driver.manage().window().maximize();
		driver.get(rp.getBasedUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger = Logger.getLogger("smallProject");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterClass	
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
