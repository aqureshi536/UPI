package com.our.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.dao.FundTransferDAO;
import com.our.model.Account;
import com.our.response.Response;
import com.our.utils.Constants;
import com.our.utils.Utility;

@Service(value = "fundTransferService")
public class FundTransferService {

	@Autowired
	private FundTransferDAO fundTransferDAO;

	@Autowired
	private Utility utility;

	public Response doFundTransfer(String accountNo, String amount) {
		Account account = new Account();
		Response response = new Response();
		try {
			if (accountNo != null && amount != null) {
				account = fundTransferDAO.getAccount(accountNo);
				if (account != null) {
					response = utility.checkAccountStatus(account.getStatus());
					if (Constants.RESP_SUCCESS.equals(response.getErrorCode())) {
						BigDecimal balance = new BigDecimal(account.getBalance());
						balance.add(new BigDecimal(amount));
						account.setBalance(String.valueOf(balance));
						fundTransferDAO.fundTransfer(account);
					} // status error
					else {

					}
				} // Account not exist
				else {
					response = utility.setResponse(Constants.Errors.ACCOUNT_NOT_EXIST);
				}
			}
		} catch (Exception e) {
			response.setErrorCode(Constants.Errors.RESP_GENRIC_FAILURE);
			response.setStatusCode(Constants.STATUS_FAILURE);
			e.printStackTrace();
		}
		return response;
	}

}
