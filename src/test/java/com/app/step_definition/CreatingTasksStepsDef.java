package com.app.step_definition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.app.pages.CreatingTaskSummaryPage;
import com.app.pages.CreatingTasksPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingTasksStepsDef {

	private WebDriver driver = Driver.getDriver();

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	CreatingTasksPage tasksPage = new CreatingTasksPage();
	CreatingTaskSummaryPage tasksSummaryPage = new CreatingTaskSummaryPage();
	
	Map<String, String> createTaskMap = new HashMap<>();
	Map<String, String> overviewTaskMap = new HashMap<>();
	
	@When("^I click on create task$")
	public void i_click_on_create_task() {
		dashboardPage.clickCreateTask();

	}

	@When("^Set subject as \"([^\"]*)\"$")
	public void set_subject_as(String subject) {
		tasksPage.subject.sendKeys(subject);
		createTaskMap.put("Subject", subject);
	}

	@When("^Set status as \"([^\"]*)\"$")
	public void set_status_as(String status) {
		Select statusSelect = new Select(tasksPage.status);
		statusSelect.selectByVisibleText(status);
		createTaskMap.put("Status", status);
	}

	@When("^Start date is todays date$")
	public void start_date_is_todays_date() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String todaysDate = today.format(formatter);
		System.out.println(todaysDate);

		// System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString());
		tasksPage.date_start_date.sendKeys(todaysDate + Keys.TAB);

		createTaskMap.put("Start Date", todaysDate);
	}

	@When("^Due date is (\\d+) dates after today date$")
	public void due_date_is_dates_after_today_date(int daysAhead) {
		String dueDate = LocalDate.now().plusDays(daysAhead).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
				.toString();
		tasksPage.date_due_date.sendKeys(dueDate + Keys.TAB);

		createTaskMap.put("Due Date", dueDate);
	}

	@When("^Set \"([^\"]*)\" priority$")
	public void set_priority(String priorityLevel) {
		Select prioritySelect = new Select(tasksPage.priority);
		prioritySelect.selectByVisibleText(priorityLevel);

		createTaskMap.put("Priority", priorityLevel);
	}

	@When("^Set description as \"([^\"]*)\"$")
	public void set_description_as(String setDescription) {
	    tasksPage.description.sendKeys(setDescription);
	    createTaskMap.put("Description", setDescription);
	    
	}
	
	@Then("^Save the task$")
	public void save_the_task() {
		tasksPage.buttonSave.click();
	}

	@Then("^Task details page should be displayed$")
	public void task_details_page_should_be_displayed() {
		assertTrue(tasksSummaryPage.taskOverview.isDisplayed());
		
		overviewTaskMap.put("Subject",tasksSummaryPage.subject.getText());
		overviewTaskMap.put("Status",tasksSummaryPage.status.getAttribute("value"));
		overviewTaskMap.put("Start Date",tasksSummaryPage.date_start.getText().replace(" 12:00am",""));
		overviewTaskMap.put("Due Date",tasksSummaryPage.date_due.getText().replace(" 12:00am",""));
		overviewTaskMap.put("Priority",tasksSummaryPage.priority.getAttribute("value"));
		overviewTaskMap.put("Description",tasksSummaryPage.description.getText());
		
		System.out.println(overviewTaskMap);
		System.out.println(createTaskMap);
		
	}

	

	@Then("^Data should match with create task data$")
	public void data_should_match_with_create_task_data() {
		assertEquals(overviewTaskMap, createTaskMap);
	}

}
