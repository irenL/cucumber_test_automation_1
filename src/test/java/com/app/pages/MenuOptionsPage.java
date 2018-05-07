package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class MenuOptionsPage {

private WebDriver driver;
	
	public MenuOptionsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	
}
