package crypto.blockchain.shopviacrypto.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crypto.blockchain.shopviacrypto.dto.Product;
import crypto.blockchain.shopviacrypto.repository.ProductRepository;

@Service
public class ProductDao {

	@Autowired
	ProductRepository productRepository;
	
	public void saveProduct(Product product) {
		Calendar cal= Calendar.getInstance();
		Timestamp modifiedDate= new Timestamp(cal.getTime().getTime());
		product.setModifiedDate(modifiedDate);
		product.setCreatedDate(modifiedDate);
		product.setIsDeleted(false);
		productRepository.save(product);
	}
	
	public void updateProduct(Product product) {
		Calendar cal= Calendar.getInstance();
		Timestamp modifiedDate= new Timestamp(cal.getTime().getTime());
		product.setModifiedDate(modifiedDate);
		productRepository.save(product);
	}
	
	public void deleteProduct(Product product) {
		Calendar cal= Calendar.getInstance();
		Timestamp modifiedDate= new Timestamp(cal.getTime().getTime());
		product.setModifiedDate(modifiedDate);
		product.setIsDeleted(true);
		productRepository.save(product);
	}
	
	public List<Product> findAllProduct(){
		return findAllProduct();
	}
	
	public Product findProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Product findProductByLink(String link) {
		Optional<Product> product = productRepository.findByProductURL(link).parallelStream().findFirst();
		if(product.isPresent())
			return product.get();
		else
		return null;
	}
}
