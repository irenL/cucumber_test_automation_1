package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class CreatingTasksPage {

private WebDriver driver;
	
	public CreatingTasksPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "name")
	public WebElement subject;
	
	@FindBy(id = "status")
	public WebElement status;
	
	public WebElement date_start_date;
	
	public WebElement date_due_date;
	
	public WebElement priority;
	
	public WebElement description;
	
	@FindBy(xpath= "//form[@id='EditView']/div[@class='buttons']/input[1]")
	public WebElement buttonSave;
	
}
