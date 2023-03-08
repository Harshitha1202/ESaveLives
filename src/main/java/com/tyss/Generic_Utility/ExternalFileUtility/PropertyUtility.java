package com.tyss.Generic_Utility.ExternalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.tyss.Generic_Utility.Enums.ExcelSheet.PropertyKey;

public class PropertyUtility {

		private Properties prop;
		

		
		/**
		 * this method is used to initialize property file
		 * @param filePath
		 */
		public PropertyUtility(String filePath)
		{
			FileInputStream fisProperty=null;
			try {
				fisProperty = new FileInputStream(filePath);
			} catch (FileNotFoundException e1) {
				
			}
			prop = new Properties();
			try {
				prop.load(fisProperty);
				
			} catch (IOException e) {
				
			}
			try {
				fisProperty.close();
			} catch (IOException e) {
				
			}
		}
		
		public PropertyUtility(){
			
		}
		

		
		/**
		 * This method is used to initialize property file
		 * @param filePath
		 */
		@Deprecated
		public void initializePropertyFile(String filePath)
		{
			FileInputStream fisProperty=null;
			try {
				fisProperty = new FileInputStream(filePath);
			} catch (FileNotFoundException e1) {
				
			}
			prop = new Properties();
			try {
				prop.load(fisProperty);
				fisProperty.close();
			} catch (IOException e) {
				
			}
			try {
				fisProperty.close();
			} catch (IOException e) {
				
			}
				
			
		}
		
		/**
		 * this method is used to fetch the key from the property file
		 * @param key
		 * @return
		 */
		public String getPropertyData(PropertyKey key)
		{
			String keyString= key.name().toLowerCase();
			String value= prop.getProperty(keyString, "please give proper key'"+keyString+"'").trim();
			return value;
		}
		
		
		

}









