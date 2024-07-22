package Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import GenericLibrary.JavaUtility;
import PojoClass.createProjectPojo;
import io.restassured.http.ContentType;

public class DataProviders {

	@DataProvider(name = "getData")
	public Object[][] data() {
		Object[][] data = new Object[3][4];

		data[0][0] = "Hi";
		data[0][1] = "Tyss";
		data[0][2] = "Completed";
		data[0][3] = 12;

		data[1][0] = "Bye";
		data[1][1] = "Qspiders";
		data[1][2] = "On Going";
		data[1][3] = 13;

		data[2][0] = "Hello";
		data[2][1] = "Jspiders";
		data[2][2] = "Active";
		data[2][3] = 15;

		return data;
	}

	@Test(dataProvider = "getData") 
	public void ddt(String createdBy, String projectName, String status,int teamSize) {
		JavaUtility jUtil = new JavaUtility();
		createProjectPojo cpp = new createProjectPojo(createdBy, projectName+jUtil.RandomNumber(), status, teamSize);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given()
		.body(cpp)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(1100l),TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON)
		.log().all();
	}
}