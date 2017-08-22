package com.our.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	private String accountId;
	private String accountNo;
	private String ifsc;
	private Date updatedDate;
	private Date recordDate;
	private String status;
	private String balance;
	@OneToMany(mappedBy = "account")
	private List<ATM> atm;
	@OneToMany(mappedBy = "account")
	private List<FundTransfer> fundTransfer;
	@ManyToOne
	private Customer customer;
	private int isActive;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public List<ATM> getAtm() {
		return atm;
	}

	public void setAtm(List<ATM> atm) {
		this.atm = atm;
	}

	public List<FundTransfer> getFundTransfer() {
		return fundTransfer;
	}

	public void setFundTransfer(List<FundTransfer> fundTransfer) {
		this.fundTransfer = fundTransfer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNo=" + accountNo + ", ifsc=" + ifsc + ", updatedDate="
				+ updatedDate + ", recordDate=" + recordDate + ", status=" + status + ", balance=" + balance + ", atm="
				+ atm + ", isActive=" + isActive + "]";
	}

}
