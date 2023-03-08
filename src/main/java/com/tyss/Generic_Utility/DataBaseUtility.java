package com.tyss.Generic_Utility;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.cj.jdbc.Driver;


/**
 * This class contains generic methods related to database
 * @author 
 *
 */
public class DataBaseUtility {

	Driver dbDriver;
	Connection connection;
	Statement statement;
	ResultSet result;
	String stringData;
	int integerData;
	int updateResult;
	
	/**
	 * 
	 */
	public DataBaseUtility()
	{
		
	}
	
	/**
	 * This method is used to open the database connection and initialize the connection, statement
	 * @param url
	 * @param userName
	 * @param password
	 */
	public DataBaseUtility(String url, String userName, String password) {
		initializeDatabase(url, userName, password);
	}
	
	/**
	 * This method will initialize the database
	 * @param userName
	 * @param password
	 */
	@Deprecated
	public void initializeDatabase(String url, String userName, String password)
	{
		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to fetch the data from database to do the SQL actions database
	 * @param query
	 * @param columnName
	 * @return 
	 */
	public ArrayList<String> getDataFromDatabase(String query, String columnName)
	{
		ArrayList<String> list = new ArrayList<>();
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(result.next())
			{
				try {
					list.add(result.getString(columnName));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	/**
	 * This method is used to validate the data 
	 * it is present in database or not
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 */
	public boolean validateDataInDatabase(String query, String columnName, String expData)
	{
		ArrayList<String> list = getDataFromDatabase(query, columnName);
		boolean flag = false;
		for(String actData:list)
		{
			if(actData.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method will give data present into the database in String format
	 * @param query
	 * @return 
	 */
	public String getStringDataFromDatabase(String query, String colName) {

		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(result.next())
			{
				stringData = result.getString(colName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stringData;
	}

	/**
	 * This method will give data present into the database in integer format
	 * @param query
	 * @param colName
	 */
	public void getIntegerDataFromDatabase(String query, String colName)
	{
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(result.next())
			{
				integerData = result.getInt(colName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will take query(insert,update,delete...) 
	 * and set the data into database
	 * @param query
	 */
	public void setDataIntoDatabase(String query)
	{
		try {
			updateResult = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(updateResult>=1)
		{
			System.out.println("data added successfully");
		}
	}
	
	/**
	 * This method is used to close the database connection
	 */
	public void closeDBConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("While closing the database connection we got the exception");
		}
	}
}	