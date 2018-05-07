package com.app.step_definition;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.app.pages.HRAppDeptEmpPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Configuration;
import com.app.utilities.DBType;
import com.app.utilities.DBUtility;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HRAppStepDefs {

	private WebDriver driver = Driver.getDriver();
	private HRAppDeptEmpPage deptEmpPage = new HRAppDeptEmpPage();

	private Map<String, String> UIDepartmentData;
	private Map<String, Object> DBDepartmentData;

	@Given("^I am on DeptEmpPage$")
	public void i_am_on_DeptEmpPage() {
		driver.get(Configuration.getProperty("hrapp.url"));
	}

	@When("^I search for department id (\\d+)$")
	public void i_search_for_department_id(int deptId) {

		UIDepartmentData = new HashMap<>();

		int currentDeptId = Integer.parseInt(deptEmpPage.departmentId.getText());

		while (currentDeptId != deptId) {

			deptEmpPage.next.click();
			BrowserUtils.waitFor(2);
			deptEmpPage = new HRAppDeptEmpPage();
			BrowserUtils.waitForVisibility(deptEmpPage.departmentId, 5);
			currentDeptId = Integer.parseInt(deptEmpPage.departmentId.getText());
		}

		// add UI data to the HashMap
		UIDepartmentData.put("DEPARTMENT_NAME", deptEmpPage.departmentName.getText());
		UIDepartmentData.put("MANAGER_ID", deptEmpPage.managerId.getText());
		UIDepartmentData.put("LOCATION_ID", deptEmpPage.locationId.getText());

	}

	@Then("^I query database with sql \"([^\"]*)\"$")
	public void i_query_database_with_sql(String sql) throws SQLException {
		DBUtility.establishConnection(DBType.ORACLE);
		List<Map<String, Object>> DBDataList = DBUtility.runSQLQuery(sql);
		DBDepartmentData = DBDataList.get(0);
		DBUtility.closeConnection();
	}

	@When("^I search for email \"([^\"]*)\" to see firstname and lastname$")
	public void i_search_for_email_to_see_firstname_and_lastname(String emailId) {

		deptEmpPage.email.clear();
		deptEmpPage.email.sendKeys(emailId);
		BrowserUtils.waitFor(1);
		deptEmpPage.findDetails.click();
		BrowserUtils.waitForVisibility(deptEmpPage.firstName, 20);

		UIDepartmentData = new HashMap<>();
		BrowserUtils.waitFor(3);
		UIDepartmentData.put("FIRST_NAME", deptEmpPage.firstName.getText());
		BrowserUtils.waitFor(1);
		UIDepartmentData.put("LAST_NAME", deptEmpPage.lastName.getText());

	}

	@When("^I search for department id (\\d+) and get number of employees$")
	public void i_search_for_department_id_and_get_number_of_employees(int deptID) {
		deptEmpPage.searchForDepartment(deptID);
		deptEmpPage.detach.click();
		BrowserUtils.waitFor(2);
		BrowserUtils.scrollJSDown();
		UIDepartmentData = new HashMap<>();
		UIDepartmentData.put("EMPLOYEES_COUNT", String.valueOf(deptEmpPage.employeesCount.size()));
	}

	@Then("^UI data and Database data must match$")
	public void ui_data_and_Database_data_must_match() {
		for (String key : DBDepartmentData.keySet()) {

			assertEquals(UIDepartmentData.get(key), String.valueOf(DBDepartmentData.get(key)));
		}

		// assertEquals(UIDepartmentData.get("DEPARTMENT_NAME"),DBDepartmentData.get("DEPARTMENT_NAME"));
		// assertEquals(UIDepartmentData.get("MANAGER_ID"),String.valueOf(DBDepartmentData.get("MANAGER_ID")
		// ));
		// assertEquals(UIDepartmentData.get("LOCATION_ID"),String.valueOf(DBDepartmentData.get("LOCATION_ID"))
		// );

	}

}
