import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Authentication {
	
	@Test
	public void basicAuth() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
	}
	
	@Test
	public void digestAuth() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
	}
	
	@Test 
	public void preemptive() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
	}
	
	@Test
	public void bearerToken() {
		baseURI = "https://www.shoppersstack.com/shopping";
		JSONObject jObj = new JSONObject();
		jObj.put("email", "zxcvbn1@gmail.com");
		jObj.put("password", "Qwerty@123");
		jObj.put("role", "SHOPPER");
			Response response = given()
			.body(jObj)
			.contentType(ContentType.JSON)
			.when()
			.post("/users/login");
			String bearerToken = response.jsonPath().get("data.jwtToken");
			
		given()         // for bearer token we use oauth2
		.auth().oauth2(bearerToken)
		.when().get("/shoppers/65540")
		.then().log().all();
	}
	
	@Test
	public void oauth_2_0() {
		
		Response respnse = given()
		.formParams("client_id", "VentasInforme")
		.formParams("client_secret", "f27b27f6e9297edafba86909e9df2cdf")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://www.ventasinforme.com")
		.formParam("code" , "authorization_code")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		respnse.then().log().all();
		String token = respnse.jsonPath().get("access_token");
		
		given()
		.auth().oauth2(token)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/4958/eggs-count")
		.then().log().all();

	}
}