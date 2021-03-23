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

import crypto.blockchain.shopviacrypto.dto.PurchaseTransaction;

/**
 *
 * @author avatar
 */
@Repository
public interface PurchaseTransactionRepository extends JpaRepository<PurchaseTransaction, Long>{
 
	List<PurchaseTransaction> findByAccountUserIdAndIsCanceledAndIsDeletedAndCartOrderCompleteAndCartIsDeleted(Long userId,Boolean isCanceled,Boolean isDeleted,Boolean isOrderComplete,Boolean isCartDeleted);
	
	long count();
	
	Optional<PurchaseTransaction> findByTransactionIdAndCartOrderCompleteAndCartIsDeletedAndCartSaveForLater(Long transactionId,Boolean isOrderComplete, Boolean isDeleted,Boolean isSaveForLater);
	
}
