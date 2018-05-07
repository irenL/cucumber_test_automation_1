package com.app.step_definition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.app.pages.SuiteCRMCreateContactInfoPage;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateContactInfoStepDefs {

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateContactInfoPage createContactInfoPage = new SuiteCRMCreateContactInfoPage();
	SuiteCRMCreateContactPage createContactPage = new SuiteCRMCreateContactPage();
	
	@Given("^I open the create contact page$")
	public void i_open_the_create_contact_page() {
	    BrowserUtils.hover(dashboardPage.linkCreate);
	    dashboardPage.linkCreateContact.click();
	}

	@Given("^I enter the first name \"([^\"]*)\" and the last name \"([^\"]*)\"$")
	public void i_enter_the_first_name_and_the_last_name(String firstName, String lastName) {
	   createContactPage.firstName.sendKeys(firstName);
	   createContactPage.lastName.sendKeys(lastName);
	}

	@Given("^I enter the phone number \"([^\"]*)\"$")
	public void i_enter_the_phone_number(String officePhone) {
		createContactPage.officePhoneNumber.sendKeys(officePhone);
	}

	@Given("^I enter the departments \"([^\"]*)\"$")
	public void i_enter_the_departments(String department) {
		createContactPage.department.sendKeys(department);
	}

	@When("^I click on the save button$")
	public void i_click_on_the_save_button() {
		 createContactPage.buttonSave.click();
		
		 BrowserUtils.waitFor(4);
	if(createContactInfoPage.saveContactText.isDisplayed()) { 
		createContactInfoPage.secondSave.click();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
	//	System.out.println(createContactInfoPage.resultName.getText());
	}

	@Then("^I should see contact information for \"([^\"]*)\"$")
	public void i_should_see_contact_information_for(String fullName) {
	   assertEquals(createContactInfoPage.firstName.getText(), fullName.split(" ")[0]);
	   assertEquals(createContactInfoPage.lastName.getText(), fullName.split(" ")[1]);
	//   assertEquals(createContactInfoPage.resultName.getText(), fullName );
	}
	
}
