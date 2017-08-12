package com.our.service;

import org.springframework.stereotype.Service;

import com.our.model.Account;

@Service(value = "fundTransferService")
public class FundTransferService {

	public Account doFundTransfer(String accountNo, String amount) {
		Account account = new Account();

		return account;
	}

}
