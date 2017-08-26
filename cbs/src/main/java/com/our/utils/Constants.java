package com.our.utils;

public class Constants {

	public static final String RESP_SUCCESS = "000";
	public static final String STATUS_SUCCESS = "1";
	public static final String STATUS_FAILURE = "-1";

	// Database
	public static final String H2dbURL = "H2dbURL";
	public static final String H2dbPassword = "H2dbPassword";
	public static final String H2dbUsername = "H2dbUsername";
	public static final String H2dbdriver = "H2dbdriver";
	public static final String H2Dialect = "H2Dialect";

	public static final String MySQLdbURL = "MySQLdbURL";
	public static final String MySQLdbPassword = "MySQLdbPassword";
	public static final String MySQLdbUsername = "MySQLdbUsername";
	public static final String MySQLdbdriver = "MySQLdbdriver";
	public static final String MySQLDialect = "MySQLDialect";
	public static final String db = "db";

	// Important
	public static final String POOL_ACCOUNT = "poolAccount";

	// Extras
	public static final String configFile = "config.properties";
	public static final String DBconfigFile = "DBconfig.properties";
	public static final String ERROR_MAPPING_DOC = "cbsErrors.xml";

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
		public static final String ACCOUNT_NOT_EXIST = "010";

	}

	public class XML {
		public static final String CBS_ERRORS = "cbsErrors";
		public static final String CBS_ERROR = "error";
		public static final String CBS_ERRORCODE_ATTR = "errorCode";
		public static final String CBS_ERRORDESC_ATTR = "errorDesc";
	}

}
