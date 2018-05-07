package com.app.tests;

import static org.testng.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.utilities.DBType;
import com.app.utilities.DBUtility;

public class EmployeesDBTest {

	@BeforeClass
	public void setUp() throws SQLException {
		DBUtility.establishConnection(DBType.ORACLE);
	}

	@AfterClass
	public void tearDown() {
		DBUtility.closeConnection();
	}

	@Test
	public void countTest() throws SQLException {
		// Connect to oracle database
		/// run following sql query
		// select * from employees where job_id = 'IT_PROG'
		// more than 0 records should be returned

		int rowsCount = DBUtility.getRowsCount("select * from employees where job_id = 'IT_PROG'");
		assertTrue(rowsCount > 0);

	}

	@Test
	public void nameTestById() throws SQLException {
		// Connect to oracle database
		// Record with Employee_Id 105 should be David Austin

		String sql = "select first_name, last_name from employees where employee_id = 105";
		List<Map<String, Object>> employee_name = DBUtility.runSQLQuery(sql);
		assertEquals(employee_name.get(0).get("FIRST_NAME"), "David");
		assertEquals(employee_name.get(0).get("LAST_NAME"), "Austin");

	}
}
