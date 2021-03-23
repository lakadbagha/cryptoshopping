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

import crypto.blockchain.shopviacrypto.dto.Account;

/**
 *
 * @author avatar
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByEmail(String email);

	List<Account> findByCheckRoletype(Integer id);
	
	List<Account> findByModifyBy(Long modifyBy);
    
}
