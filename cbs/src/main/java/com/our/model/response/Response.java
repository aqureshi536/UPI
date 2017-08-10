package com.our.model.response;

public class Response {

	private String statusCode;
	private String errorCode;

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

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", errorCode=" + errorCode + "]";
	}

}
