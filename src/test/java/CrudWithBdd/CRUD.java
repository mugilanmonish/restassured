package CrudWithBdd;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CRUD {
	String projectId;
	JavaUtility jUtil = new JavaUtility();

	@Test(priority = 1)
	public void createProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Mugilan");
		jObj.put("projectName", "RAWC" + jUtil.RandomNumber());
		jObj.put("status", "Completed");
		jObj.put("teamSize", "10");

		 Response response = given()
				.body(jObj)
				.contentType(ContentType.JSON)
				.when()
				.post("http://rmgtestingserver:8084/addProject");
				response.then()
				.assertThat()
				.statusCode(201)
				.time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
				.contentType(ContentType.JSON)
				.log().all();
//		pro = response.jsonPath().get("projectId");
		
		System.out.println("========================================================================================");

	}

	@Test(priority = 2)
	public void getProject() {
		when()
		.get("http://rmgtestingserver:8084/projects/"+projectId+"")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		System.out.println("========================================================================================");
	}

	@Test(priority = 3)
	public void updateProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Mugilan");
		jObj.put("projectName", "RAWC37");
		jObj.put("status", "Completed");
		jObj.put("teamSize", "3");

		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.put("http://rmgtestingserver:8084/projects/"+projectId+"")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		System.out.println("========================================================================================");
	}

	@Test(priority = 4)
	public void deleteProject() {
		when()
		.delete("http://rmgtestingserver:8084/projects/"+projectId+"")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
}
