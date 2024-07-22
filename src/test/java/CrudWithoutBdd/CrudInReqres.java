package CrudWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CrudInReqres {
	@Test
	public void createUser() {
		JSONObject jObj = new JSONObject();
		jObj.put("name", "mugi");
		jObj.put("job", "test lead");
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		Response response = req.post("https://reqres.in/api/users");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(201, statusCode);
	}
	
	@Test
	public void updateUserPut() {
		JSONObject jObj = new JSONObject();
		jObj.put("name", "mugil");
		jObj.put("job", "manager");
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		
		Response response = req.put("https://reqres.in/api/users/654");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode);
	}
	
	@Test
	public void updateUserPatch() {
		JSONObject jObj = new JSONObject();
		jObj.put("job", "SDET Manager");
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		
		Response response = req.patch("https://reqres.in/api/users/654");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode);
	}
	
	@Test
	public void getSingleUser() {
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(200, statusCode);
	}
	@Test
	public void deleteUser() {
		Response response = RestAssured.delete("https://reqres.in/api/users/654");
		response.then().log().all();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(204, statusCode);
	}
}
