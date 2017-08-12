package com.our.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.our.dao.ErrorDAO;
import com.our.response.Response;

import com.our.model.Error;

@Component(value = "utility")
public class Utility {

	@Autowired
	private ErrorDAO errorDAO;

	public Response checkAccountStatus(String status) {
		Response response = new Response();
		try {
			Error error = errorDAO.getErrorCode(status);
			if (Constants.RESP_SUCCESS.equals(error.getErrorCode())) {
				response.setStatusCode(Constants.STATUS_SUCCESS);
				response.setErrorCode(error.getErrorCode());
			} else {
				response.setStatusCode(Constants.STATUS_FAILURE);
				response.setErrorCode(error.getErrorCode());
			}
			response.setErrorDesc(error.getErrorDesc());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
