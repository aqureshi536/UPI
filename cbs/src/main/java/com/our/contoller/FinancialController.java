package com.our.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.our.model.response.Response;

@RestController
public class FinancialController {

	@RequestMapping("/fundtransfer")
	public Response fundtransfer() {

		Response r = new Response();
		r.setErrorCode("111");
		r.setStatusCode("000");

		return r;
	}

}
