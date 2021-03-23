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
import javax.persistence.Table;

//import com.example.DTO.WalletTransaction;

/**
 *
 * @author avatar
 */
@Entity
@Table(name="CRYPTOCURRENCY_GROUP")
public class CryptoCurrency{


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long cryptoCurrencyId;
    
    @Column(name = "CRYPTO_CURRENCY_NAME")
    private String cryptoCurrencyName;
    
    @Column(name = "CRYPTOCURRENCY_KEY")
    private String cryptoCurrencyKey;
    
    @Column(name = "SERVICE_FEE")
    private Float serviceFee;
    
    @Column(name = "EXCHANGE_FEE")
    private Float exchangeFee;
    
    @Column(name = "OTHER_CHARGE")
    private Float otherCharge;
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name = "MODIFY_BY")
    private Long modifyBy;
    
    @Column(name = "WALLET_ADDRESS")
    private String walletAddress;
    
    @Column(name ="PUBLIC_KEY")
    private String publicKey;
    
    @Column(name="API_KEY")
    private String apiKey;
    
    @Column(name ="COUNTRY")
    private String merchantCountry;
    
    
    @Column(name="CALLBACK_URL")
    private String callbackUrl;
    
    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    
//    @OneToMany(mappedBy = "cryptoCurrency")
//    private Set<WalletTransaction> walletTransaction= new HashSet<>();

    /**
     * @return the cryptoCurrencyId
     */
    public Long getCryptoCurrencyId() {
        return cryptoCurrencyId;
    }

    /**
     * @param cryptoCurrencyId the cryptoCurrencyId to set
     */
    public void setCryptoCurrencyId(Long cryptoCurrencyId) {
        this.cryptoCurrencyId = cryptoCurrencyId;
    }

    /**
     * @return the cryptoCurrencyName
     */
    public String getCryptoCurrencyName() {
        return cryptoCurrencyName;
    }

    /**
     * @param cryptoCurrencyName the cryptoCurrencyName to set
     */
    public void setCryptoCurrencyName(String cryptoCurrencyName) {
        this.cryptoCurrencyName = cryptoCurrencyName;
    }

    /**
     * @return the cryptoCurrencyKey
     */
    public String getCryptoCurrencyKey() {
        return cryptoCurrencyKey;
    }

    /**
     * @param cryptoCurrencyKey the cryptoCurrencyKey to set
     */
    public void setCryptoCurrencyKey(String cryptoCurrencyKey) {
        this.cryptoCurrencyKey = cryptoCurrencyKey;
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

//    /**
//     * @return the walletTransaction
//     */
//    public Set<WalletTransaction> getWalletTransaction() {
//        return walletTransaction;
//    }
//
//    /**
//     * @param walletTransaction the walletTransaction to set
//     */
//    public void setWalletTransaction(Set<WalletTransaction> walletTransaction) {
//        this.walletTransaction = walletTransaction;
//    }

    /**
     * @return the otherCharge
     */
    public Float getOtherCharge() {
        return otherCharge;
    }

    /**
     * @param otherCharge the otherCharge to set
     */
    public void setOtherCharge(Float otherCharge) {
        this.otherCharge = otherCharge;
    }

	public Float getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(Float serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Float getExchangeFee() {
		return exchangeFee;
	}

	public void setExchangeFee(Float exchangeFee) {
		this.exchangeFee = exchangeFee;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getMerchantCountry() {
		return merchantCountry;
	}

	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}

	
}
