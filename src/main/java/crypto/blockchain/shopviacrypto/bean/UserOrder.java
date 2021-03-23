package crypto.blockchain.shopviacrypto.bean;

import java.util.ArrayList;
import java.util.List;

public class UserOrder {

	
	
	private Long invoiceId;

	private List<UserCart> userCarts = new ArrayList<>();

	private String cryptoCurrencyName;
	
	private Double receivedAmount;
	

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getCryptoCurrencyName() {
		return cryptoCurrencyName;
	}

	public void setCryptoCurrencyName(String cryptoCurrencyName) {
		this.cryptoCurrencyName = cryptoCurrencyName;
	}

	public Double getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(Double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public List<UserCart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(List<UserCart> userCarts) {
		this.userCarts = userCarts;
	}
	
	
}
