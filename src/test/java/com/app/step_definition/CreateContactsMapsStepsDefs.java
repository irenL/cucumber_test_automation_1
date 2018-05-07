package com.app.step_definition;

import java.util.Map;

import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateContactsMapsStepsDefs {
	
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateContactPage createContactPage = new SuiteCRMCreateContactPage();
	
	@When("^I create a new contact:$")
	public void i_create_a_new_contact(Map<String, String> contact) {
		
		BrowserUtils.hover(dashboardPage.linkCreate);
		dashboardPage.linkCreateContact.click();
		
		if(contact.get("first_name") != null) {
			createContactPage.firstName.sendKeys(contact.get("first_name"));
		}
		if(contact.get("last_name") != null) {
			createContactPage.lastName.sendKeys(contact.get("last_name"));
		}
		if(contact.get("office_phone") != null) {
			createContactPage.officePhoneNumber.sendKeys(contact.get("office_phone"));
		}
		if(contact.get("cell_phone") != null) {
			createContactPage.cellPhone.sendKeys(contact.get("cell_phone"));
		}
		BrowserUtils.waitFor(3);
		createContactPage.save();
	}
	
	@Then("^I should see contact informatio for 	\"([^\"]*)\"$")
	public void i_should_see_contact_informatio_for(String arg1) {
	   
	}
	
	@Then("^the following contact should be created:$")
	public void the_following_contact_should_be_created(DataTable arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc).
	    // Field names for YourType must match the column names in 
	    // your feature file (except for spaces and capitalization).
	   
	}
	
	
	
}
