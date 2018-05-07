package com.app.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCConnection {

	String oracleDbUrl = "jdbc:oracle:thin:@ec2-54-157-43-144.compute-1.amazonaws.com:1521:xe";
	String oracleDbUsername = "hr";
	String oracleDbPassword = "hr";

	@Test
	public void oracleJDBC() throws SQLException {
		
		Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
		
		//Statement statement = connection.createStatement();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet resultSet = statement.executeQuery("select * from countries");
		
		//  1
		
//		resultSet.next();
//		System.out.println(resultSet.getString(1));
//		System.out.println(resultSet.getString("country_name"));
//		System.out.println(resultSet.getInt("region_id"));
//		
//		resultSet.next();
//		System.out.println(resultSet.getString(1));
//		System.out.println(resultSet.getString("country_name"));
//		System.out.println(resultSet.getInt("region_id"));
//		
//		resultSet.next();
//		System.out.println(resultSet.getString(1));
//		System.out.println(resultSet.getString("country_name"));
//		System.out.println(resultSet.getInt("region_id"));
		
		//  2
		
//		while(resultSet.next()) {
//			System.out.println(resultSet.getString(1) + " - " + resultSet.getString("country_name") + " - " + resultSet.getInt("region_id") );
//		}
		
		//  3
		
//		resultSet.next();
//		System.out.println(resultSet.getRow());
//		
//		resultSet.previous();
//		resultSet.first();
//		resultSet.last();
//		System.out.println(resultSet.getRow());
		
		// 4
		
		// find out how many records in the resultSet
		resultSet.last();
		int rowsCount = resultSet.getRow();
		System.out.println("Number Of Rows : " + rowsCount);
		
		resultSet.beforeFirst();
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1) + " - " + resultSet.getString("country_name") + " - " + resultSet.getInt("region_id") );
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	
	
	
	
}
