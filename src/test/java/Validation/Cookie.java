package Validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class Cookie {
	
	@Test
	public void addCookies() {
		given()
		.cookie("AEC","AQTF6HyHlYrQIkaU76FtVTcbfLGGRzxV-up96UqkwFTmx5BImwXTIzG7ZP4", "NID","514%3DLG7pOjaQ059BxXS518W4iOYyZB6_9mkxUlpSSdp4Nf1aj_AOVNYWDFjkTEBErVnnsSx4cna9ak1hMrYq0-SdUc2eFCcb1232VGlsT2zQLqNrfLzs_AXQ5HHI9QI6JLNeYyC1dCN0d3-tIINB9nnTwtJ_BWO139a1vgkokV1VMwM")
		.when().get("https://www.google.com")
		.then().log().all();
	}
	
	@Test
	public void passCookieInfo() {
		Response resp = given()
				.when().get("https://www.google.com");
		// to get single cookie info
		String value = resp.getCookie("NID");
		System.out.println(value);
	}
	
	@Test
	public void cookieValidation() {
		when().get("https://www.google.com")
		.then()
		.cookie("AEC")
		.cookie("NID").log().all();
	}
	
	@Test
	public void getAllCokkieValue() {
		
		Response response = given()
		.when().get("https://www.google.com");
		Map<String, String> allCookie = response.getCookies();
		System.out.println(allCookie.keySet());
		for(String cookieKey : allCookie.keySet()) {
			String cookieValue = response.getCookie(cookieKey);
			System.out.println(cookieKey+"<--->"+cookieValue);
		}
	}
	
}
