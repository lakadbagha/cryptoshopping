/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crypto.blockchain.shopviacrypto.dto.Product;

/**
 *
 * @author avatar
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  
	List<Product> findByProductURL(String url);   
}
