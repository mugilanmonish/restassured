package Validation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import GenericLibrary.JavaUtility;
import PojoClass.createProjectPojo;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;

public class DataMasking {
	JavaUtility jUtil = new JavaUtility();

	@Test
	public void dataMasking() {
		createProjectPojo cpp = new createProjectPojo("Mugilan", "FireFLink"+jUtil.RandomNumber(), "On Going", 5);

		given()
		.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Pragma")))
		.body(cpp).contentType(ContentType.JSON)
		.post("http://rmgtestingserver:8084/addProject")
		.then().log().all();
	}
}