package Validation;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertTrue;

import java.util.List;


import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RmgDynamicValidation {
	
	@Test
	public void rmgValidation() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		String actualData = "TY_PROJ_10220";
		Response response = when().get("projects");
		List<String> expData = response.jsonPath().get("projectId");
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
