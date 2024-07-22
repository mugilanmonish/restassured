package Validation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;
import PojoClass.createProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResquestChaining {
	JavaUtility jUtil = new JavaUtility();
	String projectId;
	
	@Test(priority = 1)
	public void createProject() {
		createProjectPojo cpp = new createProjectPojo("mugilan", "Tyss"+jUtil.RandomNumber(), "Active", 5);

		baseURI = "http://rmgtestingserver";
		port = 8084;
		Response resp = given()
		.body(cpp)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		projectId = resp.jsonPath().get("projectId");
		resp.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON)
		.log().all();
		System.out.println("========================================================================================");
	}
	
	@Test(priority = 2)
	public void getProject() {
		given()
		.pathParam("pid", projectId)
		.when()
		.get("http://rmgtestingserver:8084/projects/{pid}")
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON)
		.log().all();
		System.out.println("========================================================================================");
	}
	
	@Test(priority = 3)
	public void updateProject() {
		createProjectPojo cpp = new createProjectPojo("mugil", "Tyss"+jUtil.RandomNumber(), "Active", 5);
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.body(cpp)
		.pathParam("pid", projectId)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/{pid}")
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
		.log().all();
		System.out.println("========================================================================================");
	}
	
	@Test(priority = 4)
	public void deleteProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.pathParam("pid", projectId)
		.when()
		.delete("/projects/{pid}")
		.then()
		.assertThat()
		.statusCode(204)
		.time(Matchers.lessThan(1500l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
