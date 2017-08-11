package com.our.request;

public class FundTransferRequest {

	private String accountNo;
	private String txnType;
	private String amount;
	private String txnTime;
	private String rrn;
	private String narration;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	@Override
	public String toString() {
		return "FundTransferRequest [accountNo=" + accountNo + ", txnType=" + txnType + ", amount=" + amount
				+ ", txnTime=" + txnTime + ", rrn=" + rrn + ", narration=" + narration + "]";
	}

}
