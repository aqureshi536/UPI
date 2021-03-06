package com.our.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;

public class PropertyLoader {
	private static PropertyLoader loader;
	private Map<String, String> propertyMap;
	private final Properties configproperties = loadPropertyFile(Constants.configFile);
	private final Properties dBproperties = loadPropertyFile(Constants.DBconfigFile);

	@Autowired
	private Utility utility;

	private PropertyLoader() {
		try {
			propertyMap = new HashMap<>();
			propertyMap.put(Constants.H2dbUsername, getDBConfigProps(Constants.H2dbUsername));
			propertyMap.put(Constants.H2dbPassword, getDBConfigProps(Constants.H2dbPassword));
			propertyMap.put(Constants.H2dbURL, getDBConfigProps(Constants.H2dbURL));
			propertyMap.put(Constants.H2dbdriver, getDBConfigProps(Constants.H2dbdriver));
			propertyMap.put(Constants.H2Dialect, getDBConfigProps(Constants.H2Dialect));

			propertyMap.put(Constants.MySQLdbUsername, getDBConfigProps(Constants.MySQLdbUsername));
			propertyMap.put(Constants.MySQLdbPassword, getDBConfigProps(Constants.MySQLdbPassword));
			propertyMap.put(Constants.MySQLdbURL, getDBConfigProps(Constants.MySQLdbURL));
			propertyMap.put(Constants.MySQLdbdriver, getDBConfigProps(Constants.MySQLdbdriver));
			propertyMap.put(Constants.MySQLDialect, getDBConfigProps(Constants.MySQLDialect));
			propertyMap.put(Constants.db, getDBConfigProps(Constants.db));
			propertyMap.put(Constants.POOL_ACCOUNT, getConfigProps(Constants.POOL_ACCOUNT));

			Document errorMappingDoc = utility.loadresourceXML(Constants.ERROR_MAPPING_DOC);
			propertyMap.put(Constants.ERROR_MAPPING_DOC, utility.documentToString(errorMappingDoc));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDBConfigProps(String key) {
		String property = "";
		property = dBproperties.getProperty(key);
		return property;
	}

	public String getConfigProps(String key) {
		String property = "";
		property = configproperties.getProperty(key);
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
