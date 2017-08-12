package com.our.utils;

public class Constants {

	public static final String RESP_SUCCESS = "000";

	// Database
	public static final String H2dbURL = "H2dbURL";
	public static final String H2dbPassword = "H2dbPassword";
	public static final String H2dbUsername = "H2dbUsername";
	public static final String H2dbdriver = "H2dbdriver";

	public static final String MySQLdbURL = "H2dbURL";
	public static final String MySQLdbPassword = "H2dbPassword";
	public static final String MySQLdbUsername = "H2dbUsername";
	public static final String MySQLdbdriver = "H2dbdriver";

	// Important
	public static final String POOL_ACCOUNT = "poolAccount";

	// Extras
	public static final String configFile = "config.properties";
	public static final String DBconfigFile = "DBconfigFile.properties";

	// Errors
	public class Errors {
		public static final String RESP_GENRIC_FAILURE = "999";
		public static final String ACCOUNT_DORMANT = "001";
		public static final String ACCOUNT_FREEZED = "002";
		public static final String ACCOUNT_WITH_MULTIPLE_NAMES = "003";
		public static final String ACCOUNT_WITH_MULTIPLE_CUST_IDS = "004";
		public static final String INSUFFICIENT_FUNDS = "005";
		public static final String TXN_NOT_PERMITTED = "006";
		public static final String ACCOUNT_CLOSED = "007";
		public static final String ACCOUNT_NOT_FOUND = "008";
		public static final String ACCOUNT_LIMIT_EXCEEDED = "009";

	}

}
