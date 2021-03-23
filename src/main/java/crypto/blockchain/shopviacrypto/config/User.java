package crypto.blockchain.shopviacrypto.config;

public class User implements AccessLevel {

	@Override
	public String viewAccountInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editAccountInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String viewWalletInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editWalletInfo() {
		// TODO Auto-generated method stub
		return NOT_ALLOW_ACCESS;
	}

	@Override
	public String viewAddressInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editAdressInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String viewLoginInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editLoginInfo() {
		// TODO Auto-generated method stub
		return NOT_ALLOW_ACCESS;
	}

	@Override
	public String viewPurchasedInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editPurchasedInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String viewWallettransaction() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editWalletTransaction() {
		// TODO Auto-generated method stub
		return NOT_ALLOW_ACCESS;
	}

	@Override
	public String viewCartInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String EditCartInfo() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String viewcryptoCurrencyGroup() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editcryptoCurrencyGroup() {
		// TODO Auto-generated method stub
		return NOT_ALLOW_ACCESS;
	}

	@Override
	public String viewProduct() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

	@Override
	public String editProduct() {
		// TODO Auto-generated method stub
		return SELF_OPERATION_ACCESS;
	}

}
