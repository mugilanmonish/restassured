package Validation;

import java.io.File;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchema {

	@Test
	public void validateSchema() {
		File file = new File(".\\src\\test\\resources\\data-container.json");
		when()
		.get("https://reqres.in/api/users?page=2")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(file))
		.log().all();
	}
}
