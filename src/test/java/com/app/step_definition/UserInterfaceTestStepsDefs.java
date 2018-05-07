package com.app.step_definition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.pages.SuiteCRMSearchResultsPage;
import com.app.utilities.Configuration;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserInterfaceTestStepsDefs {

	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMSearchResultsPage searchPage = new SuiteCRMSearchResultsPage();
	
	@Given("^I logged into suiteCRM$")
	public void i_logged_into_suiteCRM() {
	  driver.get(Configuration.getProperty("url"));
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  loginPage.login(Configuration.getProperty("username"),Configuration.getProperty("password"));
	}

	@Then("^CRM Name shouls be SuiteCRM$")
	public void crm_Name_shouls_be_SuiteCRM() {
		assertTrue(driver.getTitle().endsWith("SuiteCRM"));
	}

	@Then("^Modules should be displayed$")
	public void modules_should_be_displayed() {
		 assertTrue(dashboardPage.sales.isDisplayed());
		 assertTrue(dashboardPage.marketing.isDisplayed());
		 assertTrue(dashboardPage.support.isDisplayed());
		 assertTrue(dashboardPage.activities.isDisplayed());
		 assertTrue(dashboardPage.collaboration.isDisplayed());
		 assertTrue(dashboardPage.all.isDisplayed());
		
	}
	
	@Then("^I logout from application$")
	public void i_logout_from_application() {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   loginPage.logout();
	   
	}
	
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {

		if (dashboardPage.searchIsDisplayed()) {
			dashboardPage.searchFieldTopRight.sendKeys("John Doe");
			dashboardPage.searchButtonTopRight.click();
		} else {

			dashboardPage.searchSignTopRight.click();
			dashboardPage.searchFieldHiddenTopRight.sendKeys("John Doe");
			dashboardPage.searchButtonHiddenTopRight.click();
		}
	}

	@Then("^link for user \"([^\"]*)\" should be displayed$")
	public void link_for_user_should_be_displayed(String searchTerm) {
	   System.out.println("kkk");
	   assertTrue(searchPage.resultLink(searchTerm).isDisplayed(), searchTerm + " was not displayed");
	}
	
	@Then("^There should be (\\d+) result for \"([^\"]*)\"$")
	public void there_should_be_result_for(int count, String searchTerm) {
		int actual = searchPage.resultsLink(searchTerm).size();
		assertEquals(actual, count, "number of results did not match");
	}   
	
}
