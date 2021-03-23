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

import crypto.blockchain.shopviacrypto.bean.UserAddress;
import crypto.blockchain.shopviacrypto.bean.UserCart;
import crypto.blockchain.shopviacrypto.dao.AddressDao;
import crypto.blockchain.shopviacrypto.dao.CartDao;
import crypto.blockchain.shopviacrypto.dao.CryptoCurrencyDao;
import crypto.blockchain.shopviacrypto.dao.PurchaseTransactionDao;
import crypto.blockchain.shopviacrypto.dto.Account;
import crypto.blockchain.shopviacrypto.dto.Address;
import crypto.blockchain.shopviacrypto.dto.Cart;
import crypto.blockchain.shopviacrypto.dto.CryptoCurrency;
import crypto.blockchain.shopviacrypto.dto.PurchaseTransaction;
import crypto.blockchain.shopviacrypto.utility.BitcoinRate;
import crypto.blockchain.shopviacrypto.utility.RandomKey;
import crypto.blockchain.shopviacrypto.utility.ReceiveBTC;

@RestController
public class AddressController {

	@Autowired
	AddressDao addressDao;

	@Autowired
	CartDao cartDao;

	@Autowired
	CryptoCurrencyDao cryptoCurrencyDao;

	@Autowired
	PurchaseTransactionDao transactionDao;

	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/user/saveAddress")
	public String addAddress(HttpServletRequest request, @RequestParam String fullName,
			@RequestParam String addressLine1, @RequestParam String addressLine2, @RequestParam String city,
			@RequestParam String state, @RequestParam String country, @RequestParam String pinCode,
			@RequestParam String landMark, @RequestParam String noteOnOrder, @RequestParam String noteOnDeliver,
			@RequestParam Long phoneNumber) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			PurchaseTransaction purchaseTransaction = new PurchaseTransaction();
			if (fullName == null || fullName.length() < 3) {
				return "Please Write valid FullName";
			} else if (addressLine1 == null || addressLine1.length() < 1) {
				return "Please Write valid Address on line1";
			} else if (addressLine2 == null || addressLine2.equals("")) {
				return "Please Write Valid Address on line2";
			} else if (city == null || city.length() < 3) {
				return "Please Write Valid City";
			} else if (state == null || state.length() < 3) {
				return "Please Write a Valid State";
			} else if (country == null || country.equals("")) {
				return "Please Write a valid Country Name";
			} else if (pinCode == null || pinCode.equals("")) {
				return "Please Write a valid PinCode/zipcode/PostalCode";
			} else if (landMark == null || landMark.equals("")) {
				return "Please write a valid LandMark/NearBy";
			} else if (phoneNumber == null || phoneNumber.SIZE < 10) {
				return "Please Write a valid PhoneNumber";
			} else {
				Account account = new Account();
				account.setUserId(userId);
				RandomKey secretKey = new RandomKey();
				purchaseTransaction.setSecretKey(secretKey.randomString(10));
				Double showRate = BitcoinRate.GetBitcoinRate();
				List<Cart> carts = cartDao.findCartByUserId(userId, false, false);
				Double grandTotalBTC = 0d;
				long invoiceId = transactionDao.getInvoiceId() + 1;
				PurchaseTransaction cartTransaction = new PurchaseTransaction();
				cartTransaction.setTransactionId(invoiceId);
				for (int i = 0; i < carts.size(); i++) {
					carts.get(i).setTotalBTC(carts.get(i).getPrice() * carts.get(i).getQuantity() / showRate);
					carts.get(i).setTransaction(cartTransaction);
					grandTotalBTC = grandTotalBTC + (carts.get(i).getPrice() * carts.get(i).getQuantity() / showRate);
				}
				cartDao.updateAll(carts);
				purchaseTransaction.setAmountDue(grandTotalBTC);
				System.out.println("total btc " + grandTotalBTC);

				purchaseTransaction.setInvoiceId(invoiceId);
				CryptoCurrency currency = cryptoCurrencyDao.findCryptoCurrencyByCountry("BTC", "INDIA");
				ReceiveBTC receiveBTC = new ReceiveBTC();
				purchaseTransaction.setCurrencyRecevingAddress(receiveBTC.receiveBTCAddress(
						purchaseTransaction.getSecretKey(), invoiceId, currency.getPublicKey(), currency.getApiKey()));
				purchaseTransaction.setAccount(account);
				purchaseTransaction.setCryptoCurrency(currency);
				transactionDao.savePurchaseTransaction(purchaseTransaction);
				Address address = new Address(account, addressLine1, addressLine2, city, state, country, fullName,
						phoneNumber.toString(), pinCode, landMark, noteOnOrder, noteOnDeliver, purchaseTransaction);
				addressDao.saveAddress(address);
			}
			return "success: " + purchaseTransaction.getTransactionId();
		}
		return "Unauthorized Access/Session Expired";
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user/getAddress")
	public ModelAndView getAllAddress(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			List<Address> addresses = addressDao.findAllAddressByUserId(userId, false);
			List<UserAddress> userAddresses = new ArrayList<>();
			addresses.forEach(address -> {
				if (!address.getIsDeleted()) {
					userAddresses.add(new UserAddress(address.getAddressId(), address.getAddressLine1(),
							address.getAddressLine2(), address.getCity(), address.getRegion(), address.getCountry(),
							address.getFullName(), address.getPhoneNumber(), address.getZipCode(),
							address.getLandMark()));
				}
			});

			Double showRate = BitcoinRate.GetBitcoinRate();
			mav.addObject("bitcoinValue", showRate);
			mav.addObject("addresses", userAddresses);
			mav.setViewName("/user/userAddress.html");
			return mav;
		}
		mav.setViewName("/index.html");
		return mav;
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user/deleteAddress/{addressId}")
	public String deleteAddress(@PathVariable("addressId") Long addressId, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");

			Address address = addressDao.findAddressById(addressId, false);
			if (address.getAccount().getUserId().equals(userId)) {
				addressDao.deleteAddress(address);
				return "deleted";
			}
		}
		return "Cannot find Address.";
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user/getAddress/{addressId}")
	public UserAddress getAddress(@PathVariable("addressId") Long addressId, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");

			Address address = addressDao.findAddressById(addressId, false);
			if (address.getAccount().getUserId().equals(userId)) {
				UserAddress userAddress = new UserAddress(address.getAddressId(), address.getAddressLine1(),
						address.getAddressLine2(), address.getCity(), address.getRegion(), address.getCountry(),
						address.getFullName(), address.getPhoneNumber(), address.getZipCode(), address.getLandMark());
				return userAddress;
			}
		}
		return null;
	}
}
