package Employee;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import SerializationAndDeserialization.createEmployee2Pojo;
import SerializationAndDeserialization.createEmployee3Pojo;
import SerializationAndDeserialization.createSpouse;

public class Employee3 {
	
	@Test
	public void serialization() throws JsonGenerationException, JsonMappingException, IOException {
		int[] phone = {9876543, 9988776};
		String[] email = {"mugilan@gmail.com","monish@gmail.com"};
		createSpouse cp = new createSpouse("Nishi", "nishi@gmail.com", phone);
		createEmployee3Pojo ce3p = new createEmployee3Pojo("Mugilan", "QA", 12345, email, cp);
		ObjectMapper obj = new ObjectMapper();
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./employee3.json"), ce3p);
	}
	
	@Test
	public void deserialization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		createEmployee3Pojo emp = obj.readValue(new File("./employee3.json"), createEmployee3Pojo.class);
		System.out.println(emp.getName());
		System.out.println(emp.getEmail()[0]);
		System.out.println(emp.getEmail()[1]);
		System.out.println(emp.getJob());
		System.out.println(emp.getEmpid());
		System.out.println(emp.getSpouse().getName());
		System.out.println(emp.getSpouse().getMail());
		System.out.println(emp.getSpouse().getPhone()[0]);
		System.out.println(emp.getSpouse().getPhone()[1]);
		
	}
}