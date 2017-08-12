package com.our.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyLoader {
	private static PropertyLoader loader;
	private Map<String, String> propertyMap;
	private final Properties dBproperties = loadPropertyFile(Constants.DBconfigFile);

	private PropertyLoader() {
		try {
			propertyMap = new HashMap<>();
			propertyMap.put(Constants.H2dbUsername, getDBConfigProps(Constants.H2dbUsername));
			propertyMap.put(Constants.H2dbPassword, getDBConfigProps(Constants.H2dbPassword));
			propertyMap.put(Constants.H2dbURL, getDBConfigProps(Constants.H2dbURL));
			propertyMap.put(Constants.H2dbdriver, getDBConfigProps(Constants.H2dbdriver));

			propertyMap.put(Constants.MySQLdbUsername, getDBConfigProps(Constants.MySQLdbUsername));
			propertyMap.put(Constants.MySQLdbPassword, getDBConfigProps(Constants.MySQLdbPassword));
			propertyMap.put(Constants.MySQLdbURL, getDBConfigProps(Constants.MySQLdbURL));
			propertyMap.put(Constants.MySQLdbdriver, getDBConfigProps(Constants.MySQLdbdriver));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDBConfigProps(String key) {
		String property = "";
		property = dBproperties.getProperty(key);
		return property;
	}

	public Properties loadPropertyFile(String filename) {
		Properties props = new Properties();
		InputStream input = null;
		try {
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input != null) {
				props.load(input);
			} else {
				throw new FileNotFoundException("File not found with name " + filename);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return props;
	}

	public String getValue(String key) {
		String value = "";
		if (propertyMap.containsKey(key)) {
			value = propertyMap.get(key);
		} else {
			throw new NullPointerException("Key not found in property map named as" + key);
		}
		return value;
	}

	public static PropertyLoader getInstance() {
		if (loader == null) {
			loader = new PropertyLoader();
		}
		return loader;
	}

}
