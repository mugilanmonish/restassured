package Employee;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import SerializationAndDeserialization.createEmployeePojo;

public class Employee {
	
	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		createEmployeePojo emp = new createEmployeePojo("Mugilan", "QA", 123,"mugilan@gmail.com");
		
		ObjectMapper obj = new ObjectMapper();
		
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./employee.json"), emp);
	}
	
	@Test
	public void deserialization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		createEmployeePojo emp = obj.readValue(new File("./employee.json"), createEmployeePojo.class);
		System.out.println(emp.getName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getJob());
		System.out.println(emp.getEmpid());
	}
}