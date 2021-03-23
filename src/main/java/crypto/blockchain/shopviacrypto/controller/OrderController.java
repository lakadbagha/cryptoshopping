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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import crypto.blockchain.shopviacrypto.bean.UserCart;
import crypto.blockchain.shopviacrypto.bean.UserOrder;
import crypto.blockchain.shopviacrypto.bean.UserPurchaseTransaction;
import crypto.blockchain.shopviacrypto.dao.PurchaseTransactionDao;
import crypto.blockchain.shopviacrypto.dto.PurchaseTransaction;
import crypto.blockchain.shopviacrypto.utility.BitcoinRate;

@RestController
public class OrderController {

	@Autowired
	PurchaseTransactionDao transactionDao;

	@GetMapping("/user/getOrder/{transactionId}")
	public UserPurchaseTransaction getOrder(HttpServletRequest request,
			@PathVariable("transactionId") Long transactionId) {
		HttpSession session = request.getSession(false);
		UserPurchaseTransaction transaction = new UserPurchaseTransaction();
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			PurchaseTransaction purchaseTransaction = transactionDao.findPurchasedTransactionById(transactionId, false,
					false, false);
			System.out.println("userId " + purchaseTransaction.getTransactionId());
			if (userId.equals(purchaseTransaction.getAccount().getUserId())) {

				transaction.setAmountDue(purchaseTransaction.getAmountDue());
				transaction.setCreatedDate(purchaseTransaction.getCreatedDate());
				// transaction.setCryptoCurrencyName(purchaseTransaction.getCryptoCurrency().getCryptoCurrencyName());
				transaction.setIsCanceled(purchaseTransaction.getIsCanceled());
				transaction.setModifiedDate(purchaseTransaction.getModifiedDate());
				transaction.setReceivedAmount(purchaseTransaction.getReceivedAmount());
				transaction.setIsOrderComplete(false);
				transaction.setTransactionId(purchaseTransaction.getTransactionId());
				transaction.setReceiveTransactionId(purchaseTransaction.getReceiveTransactionId());
				transaction.setCurrencyRecevingAddress(purchaseTransaction.getCurrencyRecevingAddress());
				return transaction;
			}
		}
		return null;
	}

	@GetMapping("/user/userPayment/{transactionId}")
	public ModelAndView showPayment(HttpServletRequest request, @PathVariable("transactionId") Long transactionId) {
		ModelAndView view = new ModelAndView();
		UserPurchaseTransaction transaction = getOrder(request, transactionId);
		System.out.println(transaction.getCurrencyRecevingAddress());
		if (transaction != null) {
			Double showRate = BitcoinRate.GetBitcoinRate();
			view.addObject("bitcoinValue", showRate);
			view.addObject("transaction", transaction);
			view.setViewName("/user/userPayment.html");

		} else {
			view.setViewName("/user/dashboard");
		}
		return view;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/orderHistory")
	public List<UserOrder> getUserAllOrderHistory(HttpServletRequest request, Boolean isCanceled, Boolean isDeleted,
			Boolean isOrderComplete, Boolean isCartDeleted) {
		List<UserOrder> orders = new ArrayList<>();
		HttpSession session = request.getSession();
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			List<PurchaseTransaction> transactions = transactionDao.findPurchasedTransactionByUserId(userId, isCanceled,
					isDeleted, isOrderComplete, isCartDeleted);
			transactions.parallelStream().forEach(transaction -> {
				UserOrder order = new UserOrder();
				order.setReceivedAmount(transaction.getReceivedAmount());
				if (transaction.getReceivedAmount() != null) {
					transaction.getCart().forEach(cart -> {
						UserCart userCart = new UserCart();
						userCart.setCartId(cart.getCartId());
						userCart.setConfirmationImage(cart.getConfirmationImage());
						userCart.setCreatedDate(cart.getCreatedDate());
						userCart.setDeliveryDate(cart.getDeliveryDate());
						userCart.setModifiedDate(cart.getModifiedDate());
						userCart.setOrderId(cart.getOrderId());
						userCart.setPrice(cart.getPrice());
						userCart.setQuantity(cart.getQuantity());
						userCart.setStatus(cart.getStatus());
						userCart.setProductURL(cart.getProduct().getProductURL());
						userCart.setTotalBTCPayment(cart.getTotalBTC());
						order.getUserCarts().add(userCart);
					});
					order.setCryptoCurrencyName(transaction.getCryptoCurrency().getCryptoCurrencyName());
					order.setInvoiceId(transaction.getInvoiceId());
					order.setReceivedAmount(transaction.getReceivedAmount());
					orders.add(order);
				}
			});
		}
		return orders;
	}

	@GetMapping("/user/showOrderHistory")
	public ModelAndView showAllUserOrderHistory(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		HttpSession session = request.getSession();
		if (session != null) {
			List<UserOrder> orders = getUserAllOrderHistory(request, false, false, true, false);
			view.setViewName("/user/orderHistory.html");
			view.addObject("orders", orders);
		}
		return view;
	}
}
