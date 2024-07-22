package DifferentWaysToPostRequest;

import PojoClass.createProjectPojo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericLibrary.JavaUtility;

public class PostRequestUsingPojoClass {
	JavaUtility jUtil = new JavaUtility();
	@Test
	public void createProject() {
		createProjectPojo pojo = new createProjectPojo("abcdefg", "jslf"+jUtil.RandomNumber(), "klsdfj", 5);
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}	
}