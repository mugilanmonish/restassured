package Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class ValidateResponseBody {
	@Test
	public void ValidateResponseIsSingleObject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when().get("/projects/TY_PROJ_26442")
		.then().assertThat().body("", Matchers.instanceOf(Map.class)).log().all();
	
		/*
		 * { 
		 * "projectId": "TY_PROJ_26442", 
		 * "projectName": "Xylem1823", 
		 * "teamSize": 12,
		 * "createdBy": "Sachin", 
		 * "createdOn": "09/05/2024", 
		 * "status": "Completed" 
		 * }
		 */
		//In order to find the response is simple object
	}
	
	@Test
	public void VlaidateResponseIsArrayOfObject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when().get("/projects")
		.then().assertThat().body("", Matchers.instanceOf(List.class)).log().all();
		//In order to find the response is array of object
	}
}
