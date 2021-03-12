package com.smallProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "usernamebox")
	
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtt;
	
//	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public void setUserName(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickBtt() {
		loginBtt.click();
	}
	
	public boolean isDisplayedLogOutLnk() {
		
		return driver.getPageSource().contains("Log Out");
	}

}
