package com.smallProject.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.smallProject.pageObjects.HomePage;

public class HomePageTest extends BasedTest{
	
	
	@Test
	public void clickLoginButton(){
		HomePage hp = new HomePage(driver);
		
		hp.onClickLoginButton();
		logger.info("Home page is launched");
		String pageTitle = driver.getTitle();
		assertEquals("Login | GuruLink", pageTitle);
	}

}
