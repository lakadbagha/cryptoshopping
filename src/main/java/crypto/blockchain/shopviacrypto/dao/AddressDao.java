package crypto.blockchain.shopviacrypto.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crypto.blockchain.shopviacrypto.dto.Address;
import crypto.blockchain.shopviacrypto.repository.AddressRepository;

@Service
public class AddressDao {

	@Autowired
	AddressRepository addressRepository;
	
	public void saveAddress(Address address) {
		Calendar cal= Calendar.getInstance();
		Timestamp modifiedDate= new Timestamp(cal.getTime().getTime());
		address.setModifiedDate(modifiedDate);
		address.setCreatedDate(modifiedDate);
		address.setIsDeleted(false);
		addressRepository.save(address);
	}
	
	public List<Address> findAllAddressByUserId(Long userId,Boolean isDeleted){
		return addressRepository.findByAccountUserIdAndIsDeleted(userId,isDeleted);
	}
	
	public void updateAddress(Address address) {
		Calendar cal= Calendar.getInstance();
		Timestamp modifiedDate= new Timestamp(cal.getTime().getTime());
		address.setModifiedDate(modifiedDate);
		addressRepository.save(address);
	}
	
	public void deleteAddress(Address address) {
		Calendar cal= Calendar.getInstance();
		Timestamp modifiedDate= new Timestamp(cal.getTime().getTime());
		address.setModifiedDate(modifiedDate);
		address.setIsDeleted(true);
		addressRepository.save(address);
	}
	
	public Address findAddressById(Long addressId,Boolean isDeleted) {
		return addressRepository.findByAddressIdAndIsDeleted(addressId,isDeleted).orElse(null);
	}
	
	public List<Address> findAllAddress(){
		return addressRepository.findAll();
	}
}
