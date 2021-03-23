package crypto.blockchain.shopviacrypto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import crypto.blockchain.shopviacrypto.dao.AccountDao;
import crypto.blockchain.shopviacrypto.dto.Account;
import crypto.blockchain.shopviacrypto.utility.EmailSender;
import crypto.blockchain.shopviacrypto.utility.RandomKey;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AccountDao accountDao;

	@GetMapping("/signup")
	public String signupForm(Model model) {
		System.out.println("get signup");
		model.addAttribute("account", new Account());
		return "register";
	}

	@PostMapping("/signup")
	public String createAccount(@Valid Account account, BindingResult result, Model model,HttpServletRequest request) {
		
		Account validateEmail = accountDao.findAccountByEmail(account.getEmail());
		if (validateEmail != null) {
			result.rejectValue("email", "error.account", "An account already registered for this email.");
		}
		if (result.hasErrors()) {
			System.out.println("error " + result.getObjectName());
			logger.info("Validation errors while submitting form.");
			return "register";
		}
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		RandomKey randomkey = new RandomKey();
		account.setActivationKey(randomkey.randomString(15));
		accountDao.saveAccount(account);
		AccountActivator(request, account);
		String topic = "Please Confirm Your Email address to activate your Account.";
		String message = "Please Check You Email inbox/spam directory.";
		model.addAttribute("topic", topic);
		model.addAttribute("message", message);
		return "result/message";
	}

	private void AccountActivator(HttpServletRequest request, Account account) {
		String email = "/" + account.getEmail();
		String key = "/" + account.getActivationKey();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		EmailSender sender = new EmailSender();
		String userId = "/?id=" + bCryptPasswordEncoder.encode(account.getUserId().toString());
		String url = request.getScheme()+"://"+request.getServerName() + "/activate/account" + email + key + userId;
		sender.createAccount(url, account.getEmail());
	}
	
}
