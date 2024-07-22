package Validation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RmgValidation {
// static validation
	@Test
	public void reqresValidation() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		String actualData = "TY_PROJ_-605574016";
		Response response = when().get("projects");
		String expData = response.jsonPath().get("projectId[1]");
		System.out.println(expData);
		assertEquals(actualData, expData);
		System.out.println("Data verified");
	}
}
