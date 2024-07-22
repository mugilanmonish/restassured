package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoClass.createReqresUser;
import PojoClass.updatePatchReqresUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqresChaining {
	@Test
	public void reqres() {
		
		//create
		createReqresUser crt = new createReqresUser("mugilan", "manager");
		Response response = given()
		.body(crt)
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users");
		response.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		String id = response.jsonPath().get("id");
		
		// put
		createReqresUser upt = new createReqresUser("mugilan007","detective");
		given()
		.body(upt)
		.contentType(ContentType.JSON)
		.when()
		.put("https://reqres.in/api/users/"+id+"")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	
		// patch
		updatePatchReqresUser pct = new updatePatchReqresUser("detective pro");
		given()
		.body(pct)
		.contentType(ContentType.JSON)
		.when()
		.patch("https://reqres.in/api/users/"+id+"")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
		//delete
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id+"")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
}
