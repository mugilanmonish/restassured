package Validation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
// static validation
	@Test
	public void reqresValidation() {
		baseURI = "https://reqres.in/";
		String actualData = "michael.lawson@reqres.in";
		Response response = when().get("/api/users?page=2");
		String expData = response.jsonPath().get("data[0].email");
		System.out.println(expData);
		assertEquals(actualData, expData);
		System.out.println("Data verified");
	}
}
