package com.our.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.our.dao.ErrorDAO;
import com.our.model.Error;

@Repository(value = "errorDAO")
public class ErrorDAOImpl implements ErrorDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Error getErrorCode(String status) {
		Error error = new Error();
		String hql = "from ErrorCode where status=:status";
		Query<Error> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("status", status);
		error = query.getSingleResult();
		return error;
	}

}
