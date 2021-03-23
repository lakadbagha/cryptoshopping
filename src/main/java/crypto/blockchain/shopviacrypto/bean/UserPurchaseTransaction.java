package crypto.blockchain.shopviacrypto.bean;

import java.sql.Timestamp;

public class UserPurchaseTransaction {

	private Long transactionId;

	private String cryptoCurrencyName;

	private String currencyRecevingAddress;

	private Timestamp createdDate;

	private Timestamp modifiedDate;

	private Double amountDue;

	private Double receivedAmount;

	private String receiveTransactionId;

	private Boolean isCanceled;
	
	private Boolean isOrderComplete;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}

	public Double getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(Double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public String getReceiveTransactionId() {
		return receiveTransactionId;
	}

	public void setReceiveTransactionId(String receiveTransactionId) {
		this.receiveTransactionId = receiveTransactionId;
	}

	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public String getCryptoCurrencyName() {
		return cryptoCurrencyName;
	}

	public void setCryptoCurrencyName(String cryptoCurrencyName) {
		this.cryptoCurrencyName = cryptoCurrencyName;
	}

	public String getCurrencyRecevingAddress() {
		return currencyRecevingAddress;
	}

	public void setCurrencyRecevingAddress(String currencyRecevingAddress) {
		this.currencyRecevingAddress = currencyRecevingAddress;
	}

	public Boolean getIsOrderComplete() {
		return isOrderComplete;
	}

	public void setIsOrderComplete(Boolean isOrderComplete) {
		this.isOrderComplete = isOrderComplete;
	}

}
