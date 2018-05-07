package com.app.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

public class HRAppDeptEmpPage {

	private WebDriver driver;
	
	public HRAppDeptEmpPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "pt1:ot1")
	public WebElement departmentId;
	
	@FindBy(id= "pt1:ot2")
	public WebElement departmentName;
	
	@FindBy(id= "pt1:ot3")
	public WebElement managerId;
	
	@FindBy(id= "pt1:ot4")
	public WebElement locationId;
	
	@FindBy(id= "pt1:cb3")
	public WebElement next;
	
	@FindBy(id="pt1:r1:0:it1::content")
	public WebElement email;
	
	@FindBy(id="pt1:r1:0:cb1")
	public WebElement findDetails;
	
	@FindBy(id="pt1:r1:0:ot1")
	public WebElement firstName;
	
	@FindBy(id="pt1:r1:0:ot2")
	public WebElement lastName;
	
	@FindBy(id="pt1:pc1:_dchTbr::icon")
	public WebElement detach;
	
	@FindBy(xpath="//div[@id='pt1:pc1:t1::db']//tr")
	public List<WebElement> employeesCount;

	public void searchForDepartment(int deptId) {

		int currentDeptId = Integer.parseInt(departmentId.getText());

		while (currentDeptId != deptId) {

			next.click();
			BrowserUtils.waitFor(2);
			// deptEmpPage = new HRAppDeptEmpPage();
			BrowserUtils.waitForVisibility(departmentId, 5);
			currentDeptId = Integer.parseInt(departmentId.getText());
		}

	}
	
}
