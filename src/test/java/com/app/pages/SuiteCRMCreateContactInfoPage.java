package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateContactInfoPage {

private WebDriver driver;
	
	public SuiteCRMCreateContactInfoPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "first_name")
	public WebElement firstName;

	@FindBy(id = "last_name")
	public WebElement lastName;

	@FindBy(xpath="//h2[.='Save Contact']") 
	public WebElement saveContactText; 


	@FindBy(xpath= "//tbody/tr[@class='pagination'][2]//input[1]")
	public WebElement secondSave;

//===============================================
//	@FindBy(id = "first_name")
//	public WebElement firsName;
//
//	@FindBy(id = "last_name")
//	public WebElement lastName;





}
