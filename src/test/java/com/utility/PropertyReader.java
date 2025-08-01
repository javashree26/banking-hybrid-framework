/**
 * 
 */
package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author dhanashree
 * 
 *         PropertyReader.java
 * 
 *         Utility to read key-value pairs from config.properties file. Helps
 *         with flexible, external configuration management.
 *
 */
public class PropertyReader {

	private static Properties property;

	public static String getProperty(String key) {
		if (property == null) {
			try {
				property = new Properties();
				FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
				property.load(fis);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return property.getProperty(key);
	}
}
