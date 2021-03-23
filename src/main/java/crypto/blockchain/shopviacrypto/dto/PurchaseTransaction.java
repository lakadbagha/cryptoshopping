/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author avatar
 */
@Entity
@Table(name = "PURCHASE_TRANSACTION")
public class PurchaseTransaction{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Account account;

    @OneToMany(mappedBy="purchaseTransaction")
    @Column(name = "RECEIVER_ADDRESS")
    private List<Address> recieverAddresses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PAID_CRYPTOCURRENCY_NAME")
    private CryptoCurrency cryptoCurrency;
    
    @OneToMany(mappedBy = "transaction")
    private Set<Cart> cart = new HashSet<>();

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name ="MODIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name="MODIFY_BY")
    private Long modifyBy;
    
    @Column(name = "IS_CANCELED")
    private Boolean isCanceled;
    
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    
    @Column(name = "CURRENCY_RECEIVING_ADDRESS")
    private String currencyRecevingAddress;
    
    @Column(name = "AMOUNT_DUE")
    private Double amountDue;
    
    @Column(name = "RECEIVED_AMOUNT")
    private Double receivedAmount;
    
    @Column(name="RECEIVE_TRANSACTION_ID")
    private String receiveTransactionId;
    
    @Column(name="SECRET_KEY")
    private String secretKey;
    
    @Column(name = "INVOICE_ID")
	private Long invoiceId;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public List<Address> getRecieverAddresses() {
		return recieverAddresses;
	}

	public void setRecieverAddresses(List<Address> recieverAddresses) {
		this.recieverAddresses = recieverAddresses;
	}

	public CryptoCurrency getCryptoCurrency() {
		return cryptoCurrency;
	}

	public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public String getCurrencyRecevingAddress() {
		return currencyRecevingAddress;
	}

	public void setCurrencyRecevingAddress(String currencyRecevingAddress) {
		this.currencyRecevingAddress = currencyRecevingAddress;
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

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	
}
