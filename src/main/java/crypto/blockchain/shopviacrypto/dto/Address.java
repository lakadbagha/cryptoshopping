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
@Table(name="SHOPPING_ADDRESS")
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private Account account ;
    
    @Column(name = "ADRESS_LINE1")
    private String addressLine1;
    
    @Column(name="ADDRESS_LINE2")
    private String addressLine2;
    
    @Column(name="CITY")
    private String city;
    
    @Column(name="REGION")
    private String region;
    
    @Column(name="COUNTRY")
    private String country;
    
    @Column(name="FULL_NAME")
    private String fullName;
    
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    
    @Column(name="POSTAL_CODE")
    private String zipCode;
    
    @Column(name="LAND_MARK")
    private String landMark;
    
    @Column(name="NOTES_FOR_ORDER")
    private String notesForOrder;
    
    @Column(name="NOTES_FOR_DELIVER")
    private String notesForDeliver;
    
    @Column(name="MODIFIED_BY")
    private Long modifiedBy;
    
    @Column(name="CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name="MODIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name="IS_DELETED")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name="PURCHASED_TRANSACTION")
    private PurchaseTransaction purchaseTransaction;
    
    /**
     * @return the addressLine1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @param addressLine1 the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param AddressLine2 the AddressLine2 to set
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the Country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the landMark
     */
    public String getLandMark() {
        return landMark;
    }

    /**
     * @param landMark the landMark to set
     */
    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    /**
     * @return the notesForOrder
     */
    public String getNotesForOrder() {
        return notesForOrder;
    }

    /**
     * @param notesForOrder the notesForOrder to set
     */
    public void setNotesForOrder(String notesForOrder) {
        this.notesForOrder = notesForOrder;
    }


    /**
     * @return the modifiedBy
     */
    public Long getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
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

	public PurchaseTransaction getPurchaseTransaction() {
		return purchaseTransaction;
	}

	public void setPurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		this.purchaseTransaction = purchaseTransaction;
	}
	

	public Address() {
	}

	public Address(Account account, String addressLine1, String addressLine2, String city,
			String region, String country, String fullName, String phoneNumber, String zipCode, String landMark,
			String notesForOrder, String notesForDeliver,PurchaseTransaction purchaseTransaction) {
		super();
		this.account = account;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.purchaseTransaction = purchaseTransaction;
		this.region = region;
		this.country = country;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.landMark = landMark;
		this.notesForOrder = notesForOrder;
		this.notesForDeliver = notesForDeliver;
	}

	public String getNotesForDeliver() {
		return notesForDeliver;
	}

	public void setNotesForDeliver(String notesForDeliver) {
		this.notesForDeliver = notesForDeliver;
	}
    
    
}
