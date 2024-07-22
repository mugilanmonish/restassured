package ComplexResponse;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class KarthicScenario {

	@Test
	public void demo() throws IOException, ParseException {
		JSONParser parser = new JSONParser();	
		FileReader reader = new FileReader(".\\src\\test\\resources\\jsonSample.json"); 
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject keyObject = (JSONObject) jsonObject.get("data.*.name");
		String value = (String) keyObject.get(""); 
	}
}
