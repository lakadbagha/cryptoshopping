package crypto.blockchain.shopviacrypto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import crypto.blockchain.shopviacrypto.bean.UserCart;
import crypto.blockchain.shopviacrypto.dao.CartDao;
import crypto.blockchain.shopviacrypto.dao.ProductDao;
import crypto.blockchain.shopviacrypto.dto.Account;
import crypto.blockchain.shopviacrypto.dto.Cart;
import crypto.blockchain.shopviacrypto.dto.Product;
import crypto.blockchain.shopviacrypto.utility.BitcoinRate;

@RestController
public class CartController {

	@Autowired
	CartDao cartDao;

	@Autowired
	ProductDao productDao;

	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping(value = "/user/addCart", method = RequestMethod.POST)
	public String addUserCart(HttpServletRequest request, @RequestParam String productURL, @RequestParam Float price,
			@RequestParam Short quantity) {

		System.out.println("Cart Post action " + productURL + " " + price + " " + quantity);
		if (productURL.length() < 11) {
			return "Please Write Valid URL";
		} else if (price == null || price < 5) {
			return "Please Write Valid Price";
		} else if (quantity == null || quantity < 1) {
			return "Please Write Valid Quantity";
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			Product validate = productDao.findProductByLink(productURL);
			Product product = new Product();
			if (validate != null) {
				product.setProductKey(validate.getProductId());
			}
			product.setProductURL(productURL);
			productDao.saveProduct(product);
			Account account = new Account();
			account.setUserId(userId);
			Cart cart = new Cart();
			cart.setPrice(price);
			cart.setQuantity(quantity);
			cart.setStatus("UNPAID");
			cart.setAccount(account);
			cart.setProduct(product);
			cartDao.saveCart(cart);

			return "success";
		}
		return "fail";
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user/getCart")
	public ModelAndView getAllUserCart(HttpServletRequest request) {
		System.out.println("show cart invoked");
		HttpSession session = request.getSession(false);
		ModelAndView view = new ModelAndView();
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			List<Cart> carts = cartDao.findCartByUserId(userId, false, false);
			List<UserCart> userCarts = new ArrayList<>();
			carts.parallelStream().forEach(cart -> {
				userCarts.add(new UserCart(cart.getCartId(), cart.getProduct().getProductURL(), cart.getQuantity(),
						cart.getPrice(), cart.getCreatedDate(), cart.getModifiedDate(), cart.getIsDeleted()));
			});

			view.setViewName("user/userCart.html");
			Double showRate = BitcoinRate.GetBitcoinRate();
			view.addObject("bitcoinValue", showRate);
			view.addObject("carts", userCarts);
			return view;
		}
		view.setViewName("/index.html");
		return view;
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user/deleteCart/{cartId}")
	public String deleteCart(HttpServletRequest request, @PathVariable("cartId") Long cartId) {
		System.out.println(cartId);
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			Cart cart = cartDao.findByCartId(cartId);

			if (cart.getAccount().getUserId().equals(userId)) {
				cartDao.deleteCart(cart);
				return "success";
			}
		}
		return "Cannot find Cart";
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user/getCart/{cartId}")
	public UserCart getCart(HttpServletRequest request, @PathVariable("cartId") Long cartId) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			Cart cart = cartDao.findByCartId(cartId);
			UserCart userCart = new UserCart();

			if (cart.getAccount().getUserId().equals(userId)) {
				userCart.setCartId(cart.getCartId());
				userCart.setProductURL(cart.getProduct().getProductURL());
				userCart.setPrice(cart.getPrice());
				userCart.setQuantity(cart.getQuantity());
				userCart.setModifiedDate(cart.getModifiedDate());
				userCart.setCreatedDate(cart.getCreatedDate());
			}
			return userCart;
		}
		return null;
	}

	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/user/updateCart")
	public String updateCart(HttpServletRequest request, @RequestParam String productURL, @RequestParam Float price,
			@RequestParam Short quantity, @RequestParam Long cartId) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			Cart cart = cartDao.findByCartId(cartId);
			if (cart.getAccount().getUserId().equals(userId)) {
				cart.setPrice(price);
				cart.setQuantity(quantity);
				cartDao.updateCart(cart);
				return "success";
			}
		}
		return "Cannot find Cart";
	}
}
