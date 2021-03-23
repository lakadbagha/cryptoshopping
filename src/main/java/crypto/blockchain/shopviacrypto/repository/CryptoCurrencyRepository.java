/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crypto.blockchain.shopviacrypto.dto.CryptoCurrency;

/**
 *
 * @author avatar
 */
@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long>{
	
	CryptoCurrency findByCryptoCurrencyKeyAndMerchantCountry(String cryptoCurrencyKey,String country);
	
	CryptoCurrency findByCryptoCurrencyName(String cryptoCurrencyName);
	
	CryptoCurrency findByApiKey(String apiKey);
	
}
