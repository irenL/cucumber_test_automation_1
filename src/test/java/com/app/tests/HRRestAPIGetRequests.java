package com.app.tests;

import static org.testng.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class HRRestAPIGetRequests {

	
	// When I send a Get request to rest Url http://34.223.219.142:1212/ords/hr/employees
	// Then response status should be 200
	@Test (enabled=false)
	public void simpleGet() {
		when().get("http://34.223.219.142:1212/ords/hr/employees")
		.then().statusCode(200);
	}
	

	// When I send a Get request to rest Url http://34.223.219.142:1212/ords/hr/countries
	// Then I should see JSON response
	@Test (enabled=false)
	public void printResponse() {
		when().get("http://34.223.219.142:1212/ords/hr/countries")
		.body().prettyPrint();
	}
	
	// When I send a Get request to rest Url http://34.223.219.142:1212/ords/hr/countries/US
	// And Accept type is "application/json"
	// Then response status should be 200
	@Test  (enabled=false)
	public void getWithHeaders() {
		with().accept(ContentType.JSON)
		.when()
		.get("http://34.223.219.142:1212/ords/hr/countries/US")
		.then().statusCode(200);
		
	}
	
	//When I send a Get request to Url http://34.223.219.142:1212/ords/hr/employees/1234
	// Then status code is 404
	// 1234 - invalid data
	// And 
	@Test (enabled=false)
	public void getWithInvalidData() {
//		when().get(" http://34.223.219.142:1212/ords/hr/employees/1234")
//		.then().statusCode(404);
		Response response = when().get(" http://34.223.219.142:1212/ords/hr/employees/1234");
		assertEquals(response.statusCode(), 404);
		assertTrue(response.asString().contains("Not Found"));
		response.prettyPrint();
	}
	
	// When I send a Get request to rest Url http://34.223.219.142:1212/ords/hr/countries/US
		// And Accept type is json 
	// Then status code is 200
	// And Response content should be json
	// WITH, WHEN, GET,  . . .
	@Test (enabled=false)
	public void verifyContentTypeWithAssertThat() {
		String url = "http://34.223.219.142:1212/ords/hr/employees/100";
		given().accept(ContentType.JSON)
		.when().get(url)
		.then().assertThat().statusCode(200)
		.and().contentType(ContentType.JSON);
	}

	// given Accept type is JSON
	// When I send a Get request to rest Url http://34.223.219.142:1212/ords/hr/employees/100
	// Then status code is 200
	// And response content should be json
	// And first name should be "Steven"
	// And Employee_id = 100
	@Test
	public void verifyFirstName() throws URISyntaxException {
		
		URI uri = new URI("http://34.223.219.142:1212/ords/hr/employees/100");
		
		given().accept(ContentType.JSON)
		.when().get(uri)
		.then().assertThat().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().assertThat().body("first_name", Matchers.equalTo("Steven"))
		.and().assertThat().body("employee_id", Matchers.equalTo(100));
	}
	
}
