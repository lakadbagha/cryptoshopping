package crypto.blockchain.shopviacrypto.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crypto.blockchain.shopviacrypto.dto.Cart;
import crypto.blockchain.shopviacrypto.repository.CartRepository;

@Service
public class CartDao {

	@Autowired
	CartRepository cartRepository;

	public void saveCart(Cart cart) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		cart.setModifiedDate(modifiedDate);
		cart.setCreatedDate(modifiedDate);
		cart.setOrderComplete(false);
		cart.setIsDeleted(false);
		cartRepository.save(cart);
	}

	public void updateCart(Cart cart) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		cart.setModifiedDate(modifiedDate);
		cartRepository.save(cart);
	}

	public void deleteCart(Cart cart) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		cart.setModifiedDate(modifiedDate);
		cart.setCreatedDate(modifiedDate);
		cart.setIsDeleted(true);
		cartRepository.save(cart);
	}

	public List<Cart> findCartByUserId(Long userId, Boolean isDeleted, Boolean isOrderComplete) {
		return cartRepository.findByAccountUserIdAndIsDeletedAndOrderComplete(userId, isDeleted, isOrderComplete);
	}

	public List<Cart> findAllCart() {
		return cartRepository.findAll();
	}

	public Cart findByCartId(Long id) {
		return cartRepository.findById(id).orElse(null);
	}

	public int CountCartByUserId(Long userId) {
		// return cartRepository.findByAccountUserId(userId).size();
		return cartRepository.countByAccountUserIdAndIsDeletedAndOrderCompleteAndSaveForLater(userId, false, false,
				false);
	}

	public void updateAll(List<Cart> carts) {
		cartRepository.saveAll(carts);
	}

}
