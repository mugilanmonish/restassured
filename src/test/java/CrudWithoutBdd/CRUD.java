package CrudWithoutBdd;

import static org.testng.Assert.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUD {
	String projectId;
	JavaUtility jUtil = new JavaUtility();
	
	@Test(priority = 1)
	public void createProject() {
		// Step 1 --> Create pre requiste
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Mugilan");
		jObj.put("projectName", "RAWC" + jUtil.RandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", "10");

		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);

		// Step 2 --> Perform the action
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		
//		JsonPath obj = response.jsonPath(); 
//		projectId = obj.getString("projectId");
//		System.out.println(projectId);
		 
		// Step 3 --> Validate the response
	
		System.out.println("Content type-->" + response.getContentType());
		System.out.println("Response in string-->" + response.asString());
		System.out.println(response.prettyPrint()); // prettyPrint is used to print response two times
		System.out.println(response.prettyPeek()); // prettyPeek is used to print response header and response body
		System.out.println("==========================================================================");
	}

	@Test(enabled = false)
	public void getAllProjects() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test (priority = 2)
	public void getProject() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/"+projectId+"");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
		System.out.println("==========================================================================");
	}

	@Test (priority = 3)
	public void updateProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Mugilan");
		jObj.put("projectName", "RAWC37");
		jObj.put("status", "Completed");
		jObj.put("teamSize", "8");

		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);

		Response response = req.put("http://rmgtestingserver:8084/projects/"+projectId+"");
		System.out.println("Response in string-->" + response.asString());
		System.out.println(response.prettyPeek());
		System.out.println("==========================================================================");
		
	}

	@Test(priority = 4)
	public void deleteProject() {
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/"+projectId+"");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		assertEquals(204, statusCode);
		System.out.println("==========================================================================");
	}
}
