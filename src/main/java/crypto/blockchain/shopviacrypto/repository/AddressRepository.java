/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crypto.blockchain.shopviacrypto.dto.Address;

/**
 *
 * @author avatar
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    
	List<Address> findByAccountUserIdAndIsDeleted(Long userId, 
			Boolean isDeleted);
	Optional<Address> findByAddressIdAndIsDeleted(Long addressId,
			Boolean isDeleted);
}
