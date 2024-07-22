package GenericLibrary;

import java.util.Random;

import io.restassured.path.json.JsonPath;

public class JavaUtility {
	
	public int RandomNumber() {
		Random ran = new Random();
		return (ran.nextInt(500));
	}
}