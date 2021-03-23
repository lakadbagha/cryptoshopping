/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crypto.blockchain.shopviacrypto.dto.Cart;
import crypto.blockchain.shopviacrypto.dto.Product;

/**
 *
 * @author avatar
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    
	List<Cart> findByAccountUserIdAndIsDeletedAndOrderComplete(Long userId,Boolean isDeleted,Boolean isOrderComplete); 
	
	List<Product> findByProductCartCartId(Long cartId);
	
	Integer countByAccountUserIdAndIsDeletedAndOrderCompleteAndSaveForLater(Long userId,Boolean isDeleted,Boolean orderComplete, Boolean saveforLater);
}
