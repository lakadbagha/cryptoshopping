/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.dto;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author avatar
 */
@Entity
@Table(name = "WALLET_TRANSACTION")
public class WalletTransaction {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "WALLET_ID")
    private Wallet wallet;

    @Column(name = "AMOUNT")
    private Float amount;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "SENDER_ADDRESS")
    private String senderAddress;

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;

    @Column(name = "MODIFY_BY")
    private Long modifyBy;

    @ManyToOne
    @JoinColumn(name = "CRYTOCURRENCY_TYPE")
    private CryptoCurrency cryptoCurrency;

    @Column(name = "RECIEVER_ADDRESS")
    private String recieverAddress;

    @Column(name = "TRANSACTION_TYPE")
    private Boolean transactionType;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    /**
     * @return the transactionId
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }


    /**
     * @return the amount
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the senderAddress
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * @param senderAddress the senderAddress to set
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     * @return the createdDate
     */
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the modifiedDate
     */
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return the modifyBy
     */
    public Long getModifyBy() {
        return modifyBy;
    }

    /**
     * @param modifyBy the modifyBy to set
     */
    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * @return the recieverAddress
     */
    public String getRecieverAddress() {
        return recieverAddress;
    }

    /**
     * @param recieverAddress the recieverAddress to set
     */
    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }

    /**
     * @return the transactionType
     */
    public Boolean getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(Boolean transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the cryptoCurrency
     */
    public CryptoCurrency getCryptoCurrency() {
        return cryptoCurrency;
    }

    /**
     * @param cryptoCurrency the cryptoCurrency to set
     */
    public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    /**
     * @return the wallet
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * @param wallet the wallet to set
     */
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

}
