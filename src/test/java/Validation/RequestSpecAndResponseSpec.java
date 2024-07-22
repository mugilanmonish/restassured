package Validation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import GenericLibrary.JavaUtility;
import PojoClass.createProjectPojo;
import PojoClass.createReqresUser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecAndResponseSpec {
	JavaUtility jUtil = new JavaUtility();
	@Test
	public void createProj() {
		
		createProjectPojo cpp = new createProjectPojo("Mugi", "HOOK"+jUtil.RandomNumber(), "On going", 5);
		
		RequestSpecification request = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		
		ResponseSpecification response = new ResponseSpecBuilder()
				 .expectContentType(ContentType.JSON)
				 .expectStatusCode(201).build();
		
		given().spec(request).body(cpp)
				.when().post("/addProject")
				.then().spec(response).log().all();
	}
	
	@Test
	public void createUser() {
		
		RequestSpecification request = new RequestSpecBuilder()
				.setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON)
				.addPathParam("u", "users")
				.addQueryParam("page", 2)
				.build();
		
		 ResponseSpecification response = new ResponseSpecBuilder()
				 .expectContentType(ContentType.JSON)
				 .expectStatusCode(200).build();
		 given().spec(request)
		 .when().get("/api/{u}")
		 .then().spec(response).log().all();
	}

}
