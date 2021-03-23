package crypto.blockchain.shopviacrypto.bean;

import java.sql.Timestamp;

public class UserCart {

	private Long cartId;

	private String productURL;

	private Short quantity;

	private Float price;

	private Timestamp deliveryDate;

	private String orderId;

	private Double totalBTCPayment;

	private Timestamp createdDate;

	private Timestamp modifiedDate;

	private String status;

	private String confirmationImage;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public String getProductURL() {
		return productURL;
	}

	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
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

	public UserCart(Long cartId, String productURL, Timestamp createdDate) {
		super();
		this.cartId = cartId;
		this.productURL = productURL;
		this.createdDate = createdDate;
	}

	public UserCart(Long cartId, String productURL, Short quantity, Float price, Timestamp createdDate,
			Timestamp modifiedDate, Boolean isDeleted) {
		super();
		this.cartId = cartId;
		this.productURL = productURL;
		this.quantity = quantity;
		this.price = price;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public UserCart() {
		// TODO Auto-generated constructor stub
	}

	public Double getTotalBTCPayment() {
		return totalBTCPayment;
	}

	public void setTotalBTCPayment(Double totalBTCPayment) {
		this.totalBTCPayment = totalBTCPayment;
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

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfirmationImage() {
		return confirmationImage;
	}

	public void setConfirmationImage(String confirmationImage) {
		this.confirmationImage = confirmationImage;
	}

	
}
