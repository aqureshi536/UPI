package com.our.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Error {

	@Id
	private long errorCodeId;
	private String status;
	private String errorCode;
	private String errorDesc;

	public long getErrorCodeId() {
		return errorCodeId;
	}

	public void setErrorCodeId(long errorCodeId) {
		this.errorCodeId = errorCodeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
