package com.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

public class SuiteCRMDashboardPage {

	private WebDriver driver;
	
	public SuiteCRMDashboardPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="grouptab_0")
	public WebElement sales;
	
	@FindBy(id="grouptab_1")
	public WebElement marketing;
	
	@FindBy(id="grouptab_2")
	public WebElement support;
	
	@FindBy(id="grouptab_3")
	public WebElement activities;
	
	@FindBy(id="grouptab_4")
	public WebElement collaboration;
	
	@FindBy(id="grouptab_5")
	public WebElement all;
	
	@FindBy(xpath= "//div[@class='dashletNonTable']//input[@id='text']")
	public WebElement postField;
	
	@FindBy(xpath= "//div[@class='dashletNonTable']//input[@value='Post']")
	public WebElement postButton;
	
	public void postNote(String note) {
		postField.sendKeys(note);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		postButton.click();
	}
	
	
	@FindBy(xpath= "//div[@class='desktop-bar']/ul/li[3]/form/div/input") 
	public WebElement searchFieldTopRight;
	
	@FindBy(xpath= "//div[@class='desktop-bar']/ul/li[3]/form/div/span/button") 
	public WebElement searchButtonTopRight;
	
	public boolean searchIsDisplayed() {
		boolean signin;

		try {
			signin = searchFieldTopRight.isDisplayed();
		} catch (NoSuchElementException e) {
			signin = false;
		}
		return signin;
	}
	
	@FindBy(xpath= "//div[@class='desktop-bar']/ul/li[2]/button")
	public WebElement searchSignTopRight;
	
	@FindBy(xpath= "//div[@class='desktop-bar']/ul/li[2]/div/form/div/input")
	public WebElement searchFieldHiddenTopRight;
	
	@FindBy(xpath= "//div[@class='desktop-bar']/ul/li[2]/div/form/div/span/button")
	public WebElement searchButtonHiddenTopRight;

	@FindBy(linkText = "CREATE") 
	public WebElement linkCreate;
	
	@FindBy(linkText = "Create Task") 
	public WebElement linkCreateTask;
	
	@FindBy(linkText = "Create Contact") 
	public WebElement linkCreateContact;
	
	public void clickCreateTask() {
		Actions action = new Actions(driver);
		action.moveToElement(linkCreate).perform();
		BrowserUtils.waitForVisibility(linkCreateTask, 5);
		linkCreateTask.click();
		
	}

	public List<WebElement> topMenuOptions(String name) {
		// a[.='Marketing]/..//li/a
		String xpath = "//a[.='"+ name +"']/..//li/a";

		return driver.findElements(By.xpath(xpath));
	}
	
	
//	public List<WebElement> topMenuOptions(String name) {
//		String xpath = "//a[.='" + name + "']/..//li/a";
//		return driver.findElements(By.xpath(xpath));
//	}
	
}
