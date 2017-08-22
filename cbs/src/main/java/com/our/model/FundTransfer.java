package com.our.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FundTransfer {
	@Id
	private String fundTransferId;
	private long amount;
	private String narration;
	private String txnType;
	private String recordDate;
	private String rrn;
	private String extras;
	private String accountNo;
	@ManyToOne
	private Account account;

	public String getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(String fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "FundTransfer [fundTransferId=" + fundTransferId + ", amount=" + amount + ", narration=" + narration
				+ ", txnType=" + txnType + ", recordDate=" + recordDate + ", rrn=" + rrn + ", extras=" + extras
				+ ", accountNo=" + accountNo + "]";
	}

}
