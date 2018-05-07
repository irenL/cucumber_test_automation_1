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

public class Metadata {

	String oracleDbUrl = "jdbc:oracle:thin:@ec2-54-157-43-144.compute-1.amazonaws.com:1521:xe";
	String oracleDbUsername = "hr";
	String oracleDbPassword = "hr";
	
	@Test
	public void jdbcMetadata() throws SQLException {
		
		Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
		
		//Statement statement = connection.createStatement();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		//String sql = "select employee_id,last_name,job_id,salary from employees";
		String sql = "select * from employees";
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		// Database metadata 
		DatabaseMetaData dbMetadata = connection.getMetaData();
		System.out.println("User: "+ dbMetadata.getUserName());
		System.out.println("Database type: "+ dbMetadata.getDatabaseProductName());
		
		// resultSet metadata
		ResultSetMetaData rsMetadata = resultSet.getMetaData();
		System.out.println("Column count: "+ rsMetadata.getColumnCount());
		System.out.println(rsMetadata.getColumnName(1));
		
		// print all column names using a loop
		
		for(int i = 1; i <= rsMetadata.getColumnCount(); i++) {
			System.out.println(i + " -> "+ rsMetadata.getColumnName(i));
		}
		
	
		
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	
}
