package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Driver driver;
	Connection con;
	
	public void connectDb() throws SQLException {
		driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(Iconstants.dbURL, Iconstants.dbUsername, Iconstants.dbPassword);
	}
	
	public String readDataFromDbAndVAlidate(String query, int columnIndex, String expData) throws SQLException {
		boolean flag = false; 
		ResultSet result = con.createStatement().executeQuery(query);
		 while(result.next()) {
			 if(result.getString(columnIndex).equalsIgnoreCase(expData)) {
				 flag = true;
				 break;
			 }
		 }
		 if(flag)  {
			 System.out.println("verified");
			 return expData;
		 } else {
			 System.out.println("Not verified");
			 return "no data available";
		 }
			 
	}
	
	public void closeDB() throws SQLException {
		con.close();
	}
}
