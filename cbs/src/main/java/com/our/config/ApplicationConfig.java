package com.our.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.our.model.ATM;
import com.our.model.Account;
import com.our.model.Customer;
import com.our.model.FundTransfer;
import com.our.utils.Constants;
import com.our.utils.PropertyLoader;

@Configuration
@Component
public class ApplicationConfig {

	private final String H2URL = PropertyLoader.getInstance().getValue(Constants.H2dbURL);
	private final String H2Password = PropertyLoader.getInstance().getValue(Constants.H2dbPassword);
	private final String H2Username = PropertyLoader.getInstance().getValue(Constants.H2dbUsername);
	private final String H2Driver = PropertyLoader.getInstance().getValue(Constants.H2dbdriver);

	private final String MySQLURL = PropertyLoader.getInstance().getValue(Constants.MySQLdbURL);
	private final String MySQLPassword = PropertyLoader.getInstance().getValue(Constants.MySQLdbPassword);
	private final String MySQLUsername = PropertyLoader.getInstance().getValue(Constants.MySQLdbUsername);
	private final String MySQLDriver = PropertyLoader.getInstance().getValue(Constants.MySQLdbdriver);

	@Bean(name = "H2dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource h2dataSource = new DriverManagerDataSource();
		h2dataSource.setUrl(H2URL);
		h2dataSource.setUsername(H2Username);
		h2dataSource.setPassword(H2Password);
		h2dataSource.setDriverClassName(H2Driver);
		return h2dataSource;
	}

	//@Bean(name = "MySQLdataSource")
	public DataSource getMysqlDataSource() {
		DriverManagerDataSource mySQLdataSource = new DriverManagerDataSource();
		mySQLdataSource.setUrl(MySQLURL);
		mySQLdataSource.setUsername(MySQLUsername);
		mySQLdataSource.setPassword(MySQLPassword);
		mySQLdataSource.setDriverClassName(MySQLDriver);
		return mySQLdataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Account.class);
		sessionBuilder.addAnnotatedClass(ATM.class);
		sessionBuilder.addAnnotatedClass(Customer.class);
		sessionBuilder.addAnnotatedClass(Error.class);
		sessionBuilder.addAnnotatedClass(FundTransfer.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransctionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}
}
