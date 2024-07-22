package DifferentWaysToPostRequest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class PostRequestUsingJsonFile {
	String projectId;

	@Test(priority = 1)
	public void createProject() {
				
		File file = new File(".\\src\\test\\resources\\data.json");  
		String response = given()
				.body(file)
				.contentType(ContentType.JSON)
				.when()
				.post("http://rmgtestingserver:8084/addProject")
				.then()
				.assertThat()
				.statusCode(201)
				.contentType(ContentType.JSON)
				.log().all().extract().response().asString();
		System.out.println("Response-->"+response);
		JsonPath jP = new JsonPath(response);
		projectId=jP.getString("projectId");
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

		File file = new File(".\\src\\test\\resources\\updatedData.json");
		given()
		.body(file)
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