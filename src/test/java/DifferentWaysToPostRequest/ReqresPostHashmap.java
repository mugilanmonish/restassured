package DifferentWaysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ReqresPostHashmap {
	
	@Test
	public void createUser() {
		HashMap map = new HashMap();
		map.put("name","mugilanmonish");
		map.put("job", "test lead");
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	public void getListUser() {
		when()
		.get("https://reqres.in/api/users")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
