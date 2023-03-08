package hms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataFromDatabase {

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
					int result = statement.executeUpdate("insert into employee values(04,'anu','bangalore',865456254);");
					if(result==1)
						System.out.println("data is added ");
					
					}
					finally {
						//step 6
						connection.close();
						System.out.println("closed connection");
						
					}
	

	}

}
