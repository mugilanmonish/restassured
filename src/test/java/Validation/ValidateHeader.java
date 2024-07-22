package Validation;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ValidateHeader {
	
	@Test
	public void verifyHeader() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		String expected_statusLine = "HTTP/1.1 200 ";
		String expected_Vary = "Access-Control-Request-Headers";
		String expected_ContentType = "application/json";
		String expected_pragma = "no-cache";
		String expected_Connection = "keep-alive";
		Response response = when().get("/projects/TY_proj_26442");
		response.then().log().all();
		System.out.println("---------------------------------");
		
		String statusLine = response.statusLine();
		System.out.println("statusLine---->"+statusLine);
		Assert.assertEquals(statusLine, expected_statusLine);
		
		Headers headers = response.getHeaders();
		System.out.println(headers);
		
		String actualContentType = response.getHeader("Content-Type");
		assertEquals(actualContentType, expected_ContentType);
		
		String actualPragma = response.getHeader("Pragma");
		assertEquals(actualPragma, expected_pragma);

		String actualVary = response.getHeader("Vary");
		assertEquals(actualVary, expected_Vary);
		
		String actualConnection = response.getHeader("Connection");
		assertEquals(actualConnection, expected_Connection);


	}
}
