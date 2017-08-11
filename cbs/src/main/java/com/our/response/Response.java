package com.our.response;

public class Response {

	private String statusCode;
	private String errorCode;
	private String errorDesc;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", errorCode=" + errorCode + ", errorDesc=" + errorDesc + "]";
	}

}
