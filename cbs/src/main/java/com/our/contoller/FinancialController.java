package com.our.contoller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.our.request.FundTransferRequest;
import com.our.response.Response;
import com.our.utils.Constants;

@RestController
@RequestMapping("/financial")
public class FinancialController {

	@PostMapping("/fundtransfer")
	public Response fundtransfer(@RequestBody FundTransferRequest request) {

		Response r = new Response();
		r.setErrorCode(Constants.Errors.RESP_GENRIC_FAILURE);
		r.setStatusCode(Constants.RESP_SUCCESS);
		r.setErrorDesc("SUCCESS");

		return r;
	}

}
