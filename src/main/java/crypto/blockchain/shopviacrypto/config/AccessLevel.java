package crypto.blockchain.shopviacrypto.config;

public interface AccessLevel {

	final static String NOT_ALLOW_ACCESS="NOT_ALLOW_ACCESS";
	final static String SELF_OPERATION_ACCESS="SELF_OPERATION_ACCESS";
	final static String FULL_OPERATION_ACCESS="FULL_OPERATION_ACCESS";
	
	String viewAccountInfo();
	String editAccountInfo();
	String viewWalletInfo();
	String editWalletInfo();
	String viewAddressInfo();
	String editAdressInfo();
	String viewLoginInfo();
	String editLoginInfo();
	String viewPurchasedInfo();
	String editPurchasedInfo();
	String viewWallettransaction();
	String editWalletTransaction();
	String viewCartInfo();
	String EditCartInfo();
	String viewcryptoCurrencyGroup();
	String editcryptoCurrencyGroup();
	String viewProduct();
	String editProduct();
}
