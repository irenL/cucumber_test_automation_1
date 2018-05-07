package com.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateContactPage {

private WebDriver driver;
	
	public SuiteCRMCreateContactPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "first_name")
	public WebElement firstName;
	
	@FindBy(id = "last_name")
	public WebElement lastName;
	
	@FindBy(id = "phone_work")
	public WebElement officePhoneNumber;
	
	@FindBy(id = "department")
	public WebElement department;
	
	@FindBy(id = "Contacts0emailAddress0")
	public WebElement email;
	
	@FindBy(id = "phone_mobile")
	public WebElement cellPhone;
	
	@FindBy(xpath= "//form[@id='EditView']/div[@class='buttons']/input[1]")
	public WebElement buttonSave;
	
	
	//=============================================

	@FindBy(id = "SAVE")
	public WebElement save;
	
	@FindBy(xpath = "//input[@title='Save']")
	public WebElement saveConfirmation;
	
	//====================================
	
	
	

	public void save() {
		save.click();
		try {
			Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			saveConfirmation.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
