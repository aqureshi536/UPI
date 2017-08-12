package com.our.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.our.dao.FundTransferDAO;
import com.our.model.Account;

@Repository(value = "fundTransferDAO")
public class FundTransferDAOImpl implements FundTransferDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Account fundTransfer(Account account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);
		return account;
	}

	@Transactional
	public Account getAccount(String accountNo) {
		Account account = new Account();
		String hql = "from Account where accountNo=:accountNo";
		Query<Account> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("accountNo", accountNo);
		account = query.getSingleResult();
		return account;
	}

}
