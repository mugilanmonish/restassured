package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Parameter {
	
	@Test
	public void pathParameter() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().pathParam("pid", "TY_PROJ_10220")
		.when().get("/projects/{pid}")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	@Test
	public void queryParameter() {
		baseURI = "https://reqres.in/";
		given().queryParam("page", 2)
		.when().get("api/users")
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	@Test
	public void formData() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given()
		.formParam("createdBy", "")
		.formParam("projectName", "")
		.formParam("status", "")
		.formParam("teamSize", 2)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
