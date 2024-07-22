package DifferentWaysToPostRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import PojoClass.createReqresUser;
import PojoClass.updatePatchReqresUser;
import io.restassured.http.ContentType;

public class ReqresPostPojoClass {
	
	@Test
	public void createUser() {
		createReqresUser crt = new createReqresUser("mugilan", "manager");
		
		given()
		.body(crt)
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	public void putUpdate() {
		createReqresUser upt = new createReqresUser("mugilan007","detective");
		
		given()
		.body(upt)
		.contentType(ContentType.JSON)
		.when()
		.put("https://reqres.in/api/users/78")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void patchUpdate() {
		updatePatchReqresUser pct = new updatePatchReqresUser("detective pro");
		
		given()
		.body(pct)
		.contentType(ContentType.JSON)
		.when()
		.put("https://reqres.in/api/users/78")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
