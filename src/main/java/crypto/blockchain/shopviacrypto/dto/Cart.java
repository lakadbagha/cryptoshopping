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
@Table(name = "CART")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID")
	private Long cartId;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "TRANSACTION_ID")
	private PurchaseTransaction transaction;


    @Column(name = "STATUS")
    private String status;

	@Column(name="ORDER_ID")
    private String orderId;
    
    @Column(name = "CONFIRMATION_IMAGE")
    private String confirmationImage;
    
    @Column(name = "DELIVERY_DATE")
    private Timestamp deliveryDate;
	
	@Column(name = "PRICE")
	private Float price;
    
    @Column(name = "ORDER_COMPLETE")
	private Boolean orderComplete;

	@Column(name = "QUANTITY")
	private Short Quantity;
	
	@Column(name="TOTAL_PAYMENT_IN_BTC")
	private Double TotalBTC;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "MODIFY_BY")
	private String modifyBy;

	@Column(name = "SAVE_FOR_LATER")
	private Boolean saveForLater;
	
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@Column(name = "MODIFIED_DATE")
	private Timestamp modifiedDate;

	@Column(name = "IS_DELETED")
	private Boolean isDeleted;
	
	

	/**
	 * @return the cartId
	 */
	public Long getCartId() {
		return cartId;
	}

	/**
	 * @param cartId
	 *            the cartId to set
	 */
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the modifyBy
	 */
	public String getModifyBy() {
		return modifyBy;
	}

	/**
	 * @param modifyBy
	 *            the modifyBy to set
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
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
	 * @param modifiedDate
	 *            the modifiedDate to set
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
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Short getQuantity() {
		return Quantity;
	}

	public void setQuantity(Short quantity) {
		Quantity = quantity;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getTotalBTC() {
		return TotalBTC;
	}

	public void setTotalBTC(Double totalBTC) {
		TotalBTC = totalBTC;
	}

	public PurchaseTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(PurchaseTransaction transaction) {
		this.transaction = transaction;
	}

	public Boolean getSaveForLater() {
		return saveForLater;
	}

	public void setSaveForLater(Boolean saveForLater) {
		this.saveForLater = saveForLater;
	}

	public Boolean getOrderComplete() {
		return orderComplete;
	}

	public void setOrderComplete(Boolean orderComplete) {
		this.orderComplete = orderComplete;
	}
	


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getConfirmationImage() {
		return confirmationImage;
	}

	public void setConfirmationImage(String confirmationImage) {
		this.confirmationImage = confirmationImage;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
