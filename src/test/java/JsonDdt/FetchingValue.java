package JsonDdt;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import GenericLibrary.JsonUtility;

public class FetchingValue {
	
	JsonUtility jsonUtils = new JsonUtility();
	
	@Test
	public void fetchValueInsideSimpleObject() throws IOException, ParseException  {
		
		Object page = jsonUtils.readIntegerValueFromJsonFile("total");
		System.out.println("page-->"+page);
		
		Object total = jsonUtils.readTheDataFromJsonFile("total");
		System.out.println("total-->"+total);
	}
}