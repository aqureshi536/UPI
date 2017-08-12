package com.our.dao;

import com.our.model.Account;

public interface FundTransferDAO {

	Account fundTransfer(Account account);

	Account getAccount(String accountNo);

}
