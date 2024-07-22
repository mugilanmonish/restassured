package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import io.restassured.response.Response;
import GenericLibrary.BaseClass;
import GenericLibrary.EndPointsLibrary;
import GenericLibrary.Iconstants;
import PojoClass.createProjectPojo;


public class CreateProjectAndVerifyInDbTest extends BaseClass{

	@Test(enabled = false)
	public void createProjectTest() throws SQLException {
		createProjectPojo cpp = new createProjectPojo("Mugilan", "Bangalore"+jUtil.RandomNumber(), "Completed", 5);

		Response resp = given()
				.spec(request).body(cpp)
				.when().post(EndPointsLibrary.createPoject);
		String expData =rUtil.getJsonData(resp, "projectId");
		System.out.println(expData);
		resp.then().log().all();
		String query = "select * from project;";
		String actData = dbUtil.readDataFromDbAndVAlidate(query, 1, expData);
		assertEquals(expData, actData);
		System.out.println("TC PASSED");
	}

	@Test
	public void threeLayerCheck() throws InterruptedException, SQLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys(Iconstants.appUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(Iconstants.appPassword);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		//		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();

		String projectName = "FireFlink"+jUtil.RandomNumber();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Mugilan");
		WebElement projectStatus = driver.findElement(By.name("status"));
		Select value = new Select(projectStatus);
		value.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		String projectId = driver.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td")).getText();
		System.out.println(projectId);


		Response resp = given().spec(request)
				.when().get(EndPointsLibrary.getSingleProject+projectId);
		resp.then().log().all();
		String jsonData = rUtil.getJsonData(resp, "projectId");
		assertEquals(jsonData, projectId);

		String query = "select * from project;";
		String dbData = dbUtil.readDataFromDbAndVAlidate(query, 1, projectId);
		assertEquals(dbData, projectId);
	}

	@Test
	public void threeLayerCheck2() throws InterruptedException, SQLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys(Iconstants.appUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(Iconstants.appPassword);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();

		driver.findElement(By.xpath("//span[.='Create Project']")).click();

		String projectName = "FireFlink"+jUtil.RandomNumber();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Mugilan");
		WebElement projectStatus = driver.findElement(By.name("status"));
		Select value = new Select(projectStatus);
		value.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content']")));
		String projectId = driver.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td")).getText();
		System.out.println(projectId);

		String updatedProName = "FireFlinkSouthEnd"+jUtil.RandomNumber();
		createProjectPojo cpp = new createProjectPojo(projectId, updatedProName, "Created", 10);
		Response resp = given().spec(request).body(cpp)
				.when().put(EndPointsLibrary.updateProject+projectId);
		resp.then().log().all();
		String jsonData = rUtil.getJsonData(resp, "projectName");
		assertEquals(jsonData, updatedProName);

		String query = "select * from project;";
		String dbData = dbUtil.readDataFromDbAndVAlidate(query, 3, updatedProName);
		assertEquals(dbData, updatedProName);
	}

	@Test(enabled=false)
	public void threeLayerCheck3()  throws InterruptedException, SQLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys(Iconstants.appUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(Iconstants.appPassword);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		String projectId = driver.findElement(By.xpath("//td[text()='FireFlinkNew']/preceding-sibling::td")).getText();
		System.out.println(projectId);

		Response resp = given().spec(request)
				.when().delete(EndPointsLibrary.deleteProject+projectId);
		resp.then().log().all();

		String query = "select * from project;";
		String dbData = dbUtil.readDataFromDbAndVAlidate(query, 1, projectId);
		assertEquals(dbData, "no data available");
	}

	@Test(enabled = false)
	public void threeLayerCheck4() throws SQLException {
		Driver dri = new Driver();
		DriverManager.registerDriver(dri);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		String projectId = "TY_PROj_786"+jUtil.RandomNumber();
		String projectName = "FireFire"+jUtil.RandomNumber();
		String query = "insert into project values('"+projectId+"','Mugilan','','"+projectName+"','Completed',5);";
		state.executeUpdate(query);
		
		Response resp = given().spec(request)
				.when().get(EndPointsLibrary.getSingleProject+projectId);
		resp.then().log().all();
		String jsonData = rUtil.getJsonData(resp, "projectId");
		assertEquals(jsonData, projectId);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys(Iconstants.appUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(Iconstants.appPassword);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		boolean project = false;
		try {
			driver.findElement(By.xpath("//td[text()='"+projectId+"']"));
		} catch (Exception e) {
			System.out.println("Project is not available");
			project = true;
			assertFalse(project);
		}
		
	}
}
