package GenericLibrary;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	public DatabaseUtility dbUtil = new DatabaseUtility();
	public JavaUtility jUtil = new JavaUtility();
	public RestAssuredLibrary rUtil = new RestAssuredLibrary();
	public RequestSpecification request;
	public ResponseSpecification response;

	@BeforeSuite
	public void bsConfig() throws SQLException {
		dbUtil.connectDb();
		request = new RequestSpecBuilder().setBaseUri(Iconstants.baseUri)
				.setContentType(ContentType.JSON).build();
		
		response = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@AfterSuite
	public void asConfig() throws SQLException {
		dbUtil.closeDB();
	}
}
