package com.app.step_definition;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;

import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardActionsStepFefs {

	private WebDriver driver = Driver.getDriver();
	
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	
	@When("^I post \"([^\"]*)\"$")
	public void i_post(String arg1) {
	   dashboardPage.postNote("Hello Everyone");
	}

	@Then("^Post should be displayed$")
	public void post_should_be_displayed() {
	 System.out.println("bbb");
	}
	
}
