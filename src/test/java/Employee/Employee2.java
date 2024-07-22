package Employee;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import SerializationAndDeserialization.createEmployee2Pojo;
import SerializationAndDeserialization.createEmployeePojo;

public class Employee2 {
	
	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		
		String[] mail = {"mugilan@gmail.com","monish@gmail.com"};
		createEmployee2Pojo emp2 = new createEmployee2Pojo("Monish", "TestEngineer",12345, mail);
		
		ObjectMapper obj = new ObjectMapper();
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./employee2.json"), emp2);
	}
	
	@Test
	public void deserialization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		createEmployee2Pojo emp = obj.readValue(new File("./employee2.json"), createEmployee2Pojo.class);
		System.out.println(emp.getName());
		System.out.println(emp.getEmail()[0]);
		System.out.println(emp.getEmail()[1]);
		System.out.println(emp.getJob());
		System.out.println(emp.getEmpid());
	}
}
