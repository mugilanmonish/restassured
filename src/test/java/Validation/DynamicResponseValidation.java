package Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidation {
	//dynamic response validation
	@Test
	public void reqresValidation() {
		baseURI = "https://reqres.in/";
		String actualData = "michael.lawson@reqres.in";
		Response response = when().get("/api/users?page=2");
		List<String> expData = response.jsonPath().get("data.email");
		System.out.println(expData);
		boolean flag = false;
		for(String singleData : expData) {
			if(singleData.equalsIgnoreCase(actualData)) {
				flag = true;
				break;
			}
		}
		assertTrue(flag);
		System.out.println("Data verified");
	}
}