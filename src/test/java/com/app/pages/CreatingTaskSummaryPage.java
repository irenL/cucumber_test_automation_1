package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class CreatingTaskSummaryPage extends CreatingTasksPage{

private WebDriver driver;
	
	public CreatingTaskSummaryPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement date_start;
	
	public WebElement date_due;
	
	@FindBy(linkText = "TASK OVERVIEW")
	public WebElement taskOverview;
	
	
}
