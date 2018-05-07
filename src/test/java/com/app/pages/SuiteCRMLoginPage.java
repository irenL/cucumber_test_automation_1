package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMLoginPage {

	private WebDriver driver;

	public SuiteCRMLoginPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "username_password")
	public WebElement password;

	@FindBy(id = "bigbutton")
	public WebElement login;

	@FindBy(xpath = "//li[@id='globalLinks']/button[@id='with-label']")
	public WebElement profileMenu;

	@FindBy(xpath = "//div[@class='desktop-bar']/ul/li[5]/ul/li[5]/a")
	public WebElement logoutLink;
	
	public void login(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		login.click();
	}

	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(profileMenu).moveToElement(logoutLink).click().perform();
		
	}
	
}
