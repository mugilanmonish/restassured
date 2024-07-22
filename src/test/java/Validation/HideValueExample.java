package Validation;


import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class HideValueExample {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";

        // Make a GET request to the API
        Response response = RestAssured.get("api/users?page=2");

        // Intercept the response
        ResponseBody<?> responseBody = response.getBody();
        String responseBodyString = responseBody.asString();

        // Parse the response body and modify the value
        JSONObject jsonResponse = new JSONObject(responseBodyString);
        jsonResponse.put("first_name", JSONObject.NULL); // Hiding the value by setting it to null
        
		/*
		 * // Create a new response with the modified body ValidatableResponse
		 * modifiedResponse = RestAssured.given() .body(jsonResponse.toString())
		 * .post("/someEndpoint") .then();
		 * 
		 */        // Print the modified response
        System.out.println(jsonResponse);
    }
}
