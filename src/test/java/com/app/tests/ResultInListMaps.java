package com.app.tests;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class ResultInListMaps {

	String oracleDbUrl = "jdbc:oracle:thin:@ec2-54-157-43-144.compute-1.amazonaws.com:1521:xe";
	String oracleDbUsername = "hr";
	String oracleDbPassword = "hr";

	@Test
	public void jdbcMetadataIntoListMaps() throws SQLException {

		Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);

		// Statement statement = connection.createStatement();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// String sql = "select employee_id,last_name,job_id,salary from employees";
		String sql = "select * from employees";

		ResultSet resultSet = statement.executeQuery(sql);

		// Throw resultSet into a list of Maps
		// Create a list of Maps
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSetMetaData rsMdata = resultSet.getMetaData();

		int colCount = rsMdata.getColumnCount();

		while (resultSet.next()) {
			Map<String, Object> rowMap = new HashMap<>();

			for (int col = 1; col <= colCount; col++) {
				rowMap.put(rsMdata.getColumnName(col), resultSet.getObject(col));
				
			}

			list.add(rowMap);
//			System.out.println(list+" \n");
		}
		
		// print all employee ids from a list of maps
       
       for(Map<String, Object> emp : list) {
    	   
    	   System.out.println(emp.get("EMPLOYEE_ID"));
    	   
       }
       
       
       
		resultSet.close();
		statement.close();
		connection.close();

	}

}
