/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author avatar
 */
@Entity
@Table(name="WALLET")
public class Wallet{

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "WALLET_ID")
    private Long walletId;
    
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private Account account;
    
    @Column(name = "BALANCE")
    private String balance;
    
    @Column(name = "WALLET_ADDRESS")
    private String walletAddress;
    
    @ManyToOne
    @JoinColumn(name = "CRYPTOCURRENCY_TYPE")
    private CryptoCurrency cryptoCurrency;
    
    @Column(name = "MODIFY_BY")
    private Long modifyBy;
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    
    @OneToMany(mappedBy = "wallet")
    private Set<WalletTransaction> transaction= new HashSet<>();

    /**
     * @return the walletId
     */
    public Long getWalletId() {
        return walletId;
    }

    /**
     * @param walletId the walletId to set
     */
    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * @return the walletAddress
     */
    public String getWalletAddress() {
        return walletAddress;
    }

    /**
     * @param walletAddress the walletAddress to set
     */
    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
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
     * @return the transaction
     */
    public Set<WalletTransaction> getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Set<WalletTransaction> transaction) {
        this.transaction = transaction;
    }

    
    
}
