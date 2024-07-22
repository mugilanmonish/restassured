package GenericLibrary;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String readTheDataFromJsonFile(String key) throws IOException, ParseException {
	
		// Create a JSONParser object
		// The JSONParser is used to parse JSON strings or read JSON files.
		JSONParser parser = new JSONParser();	
		
		 // Create a FileReader to read the JSON file(locate the file)
		FileReader reader = new FileReader(".\\src\\test\\resources\\ddt.json"); 
		
		// Parse the JSON file into a JSONObject
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		
		// Retrieve the value associated with the provided key from the JSONObject
		 String value = (String) jsonObject.get(key); 
		return value;
	}
	
	public Object readIntegerValueFromJsonFile(String key) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(".\\src\\test\\resources\\ddt.json");
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		Object value = jsonObject.get(key);
		return value;
	}
}