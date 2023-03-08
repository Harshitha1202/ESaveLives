package hms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import com.mysql.cj.jdbc.Driver;

public class fetchprojectdata {

		public static void main(String[] args) throws SQLException {
			// STEP 1
			Driver dbDriver= new Driver();
			DriverManager.registerDriver(dbDriver);
			Connection connection=null;
			try {
			// STEP 2-url:jdbc:mysql://localhost:3306/mydb, un, pw
			 connection = DriverManager.getConnection
					 ("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			// STEP 3
			 Statement statement = connection.createStatement();
			 ResultSet result = statement.executeQuery("select * from project");
			 int size = result.getMetaData().getColumnCount();
			 for(int i = 1; i <=size; i++)
			 {
				 System.out.println(result.getMetaData().getColumnName(i));
			 }
				 
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