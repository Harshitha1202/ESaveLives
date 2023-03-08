 package hms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		// STEP 1
		Driver dbDriver= new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connection=null;
		try {
		// STEP 2-url:jdbc:mysql://localhost:3306/mydb, un, pw
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
		// STEP 3
		 Statement statement = connection.createStatement();
		//STEP 4
		ResultSet result = statement.executeQuery("select * from employee");
		// iterate data
		while(result.next())
		{
			int empid = result.getInt(1);
			System.out.println(empid);
		}
		}
		
		finally {
			//step 6
			connection.close();
			System.out.println("closed connection");
			
		}
	}

}
