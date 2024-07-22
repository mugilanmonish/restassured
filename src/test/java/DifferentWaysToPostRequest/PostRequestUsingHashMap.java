package DifferentWaysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import GenericLibrary.JavaUtility;
import io.restassured.http.ContentType;

public class PostRequestUsingHashMap {
	JavaUtility jUtil = new  JavaUtility();
	
	@Test
	public void createProject() {
		HashMap map = new HashMap();
		map.put("createdBy", "mugi");
		map.put("projectName", "abcd"+jUtil.RandomNumber());
		map.put("status", "on going");
		map.put("teamSize", 5);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
