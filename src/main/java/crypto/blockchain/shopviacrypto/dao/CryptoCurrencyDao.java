package crypto.blockchain.shopviacrypto.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crypto.blockchain.shopviacrypto.dto.CryptoCurrency;
import crypto.blockchain.shopviacrypto.repository.CryptoCurrencyRepository;

@Service
public class CryptoCurrencyDao {

	@Autowired
	CryptoCurrencyRepository currencyRepository;

	public void saveCryptoCurrency(CryptoCurrency cryptoCurrency) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		cryptoCurrency.setModifiedDate(modifiedDate);
		cryptoCurrency.setCreatedDate(modifiedDate);
		cryptoCurrency.setIsDeleted(false);
		currencyRepository.save(cryptoCurrency);
	}

	public void updateCryptoCurrency(CryptoCurrency cryptoCurrency) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		cryptoCurrency.setModifiedDate(modifiedDate);
		currencyRepository.save(cryptoCurrency);
	}

	public void deleteCryptoCurrency(CryptoCurrency cryptoCurrency) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		cryptoCurrency.setModifiedDate(modifiedDate);
		cryptoCurrency.setIsDeleted(true);
		currencyRepository.save(cryptoCurrency);
	}

	public List<CryptoCurrency> findAllCryptoCurrency() {
		return currencyRepository.findAll();
	}

	public CryptoCurrency findCryptoCurrencyById(Long Id) {
		return currencyRepository.findById(Id).orElse(null);
	}

	public CryptoCurrency findCryptoCurrencyByCountry(String cryptoCurrencyKey,String country) {
		return currencyRepository.findByCryptoCurrencyKeyAndMerchantCountry(cryptoCurrencyKey, country);
	}
}
