package com.app.step_definition;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.pages.MenuOptionsPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepDefs {
	
	MenuOptionsPage menuOptionPage = new MenuOptionsPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	
	@When("^I hover over the (Collaboration|Sales|Support|All|Marketing|Activities) menu$")
	public void i_hover_over_the_Collaboration_menu(String menu) {
		switch (menu) {
		case "Sales":
			BrowserUtils.hover(dashboardPage.sales);
			BrowserUtils.waitFor(1);
			break;
		case "Support":
			BrowserUtils.hover(dashboardPage.support);
			BrowserUtils.waitFor(1);
			break;
		case "Collaboration":
			BrowserUtils.hover(dashboardPage.collaboration);
			BrowserUtils.waitFor(1);
			break;
		case "All":
			BrowserUtils.hover(dashboardPage.all);
			BrowserUtils.waitFor(1);
			break;
		case "Marketing":
			BrowserUtils.hover(dashboardPage.marketing);
			BrowserUtils.waitFor(1);
			break;
		case "Activities":
			BrowserUtils.hover(dashboardPage.activities);
			break;
		}

	}

	@Then("^Following menu options should be visible for Collaboration:$")
	public void following_menu_options_should_be_visible_for_Collaboration(String menu, List<String> options) {
	  List<WebElement> topMenuOptions = dashboardPage.topMenuOptions(menu);
	  List<String> topMenuOptionsString = BrowserUtils.getElementsText(topMenuOptions);
	  assertEquals(topMenuOptionsString.size(), options.size() , "Number of expected menu options did not match");
	  for(int i = 0; i < options.size(); i++) {
		  assertEquals(topMenuOptionsString.get(i), options.get(i));
	  }
	  
	}
	
}
