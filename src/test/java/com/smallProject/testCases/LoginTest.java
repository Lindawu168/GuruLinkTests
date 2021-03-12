package com.smallProject.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.smallProject.pageObjects.HomePage;
import com.smallProject.pageObjects.LoginPage;

public class LoginTest extends BasedTest {

	String loginUrl;
	
	public String getLoginUrl() {
		
		HomePage hp = new HomePage(driver);

		hp.onClickLoginButton();
		loginUrl = driver.getCurrentUrl();

		return loginUrl;

	}
	

	@Test
	public void loginTest() throws IOException {
		
		loginUrl = getLoginUrl();
		driver.get(loginUrl);
		logger.info("Launch Login Page");

		LoginPage lg = new LoginPage(driver);
		lg.setUserName(rp.getUserName());
		lg.setPassword(rp.getPassword());
		lg.clickBtt();
		logger.info("Login succeed");
		assertTrue(lg.isDisplayedLogOutLnk());
	}
}
