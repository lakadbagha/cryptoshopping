package crypto.blockchain.shopviacrypto.bean;

public class UserAddress {

	private Long AddressId;
	
	private String AddressLine1;
	
	private String AddressLine2;

	private String city;
	
	private String region;
	
	private String Country;
	
	private String fullName;
	
	private String phoneNumber;
	
	private String zipCode;
	
	private String landMark;
	
	private String notesForOrder;
	
	private String notesFordeliver;

	public Long getAddressId() {
		return AddressId;
	}

	public void setAddressId(Long addressId) {
		AddressId = addressId;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getNotesForOrder() {
		return notesForOrder;
	}

	public void setNotesForOrder(String notesForOrder) {
		this.notesForOrder = notesForOrder;
	}
	
	public String getNotesFordeliver() {
		return notesFordeliver;
	}

	public void setNotesFordeliver(String notesFordeliver) {
		this.notesFordeliver = notesFordeliver;
	}

	public UserAddress() {};
	public UserAddress(Long addressId, String addressLine1, String addressLine2, String city, String region,
			String country, String fullName, String phoneNumber, String zipCode, String landMark) {
		super();
		AddressId = addressId;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		this.city = city;
		this.region = region;
		Country = country;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.landMark = landMark;
	}
	
}
