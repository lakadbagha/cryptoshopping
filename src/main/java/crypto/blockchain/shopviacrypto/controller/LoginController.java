/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import crypto.blockchain.shopviacrypto.dao.AccountDao;
import crypto.blockchain.shopviacrypto.dao.CartDao;
import crypto.blockchain.shopviacrypto.utility.BitcoinRate;

/**
 *
 * @author avatar
 */

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	AccountDao accountDao;

	@Autowired
	CartDao cartDao;

	@RequestMapping("/index")
	public ModelAndView homePage() {
		System.out.println("index called");
		// Account account = checkCookie(request);
		ModelAndView mvc = new ModelAndView();
		// if (account != null) {
		// if (LoginAttempt(account) != null) {
		// if (redirectPageByRole(LoginAttempt(account)) != null) {
		// mvc.setViewName(redirectPageByRole(LoginAttempt(account)));
		// mvc.addObject("account", LoginAttempt(account));
		// System.out.println("SuccessFully logged in by cookie");
		// }
		// }
		// }
		System.out.println("Not successfully");
		// mvc.addObject("loginInfo", new LoginInfo());
		mvc.setViewName("index");
		return mvc;
	}

	@GetMapping("/secure")
	public String getsecure(Model model, Authentication auth, HttpServletRequest request) {
		System.out.println("get secure method invoked ");
		Long userId = accountDao.findAccountByEmail(auth.getName()).getUserId();
                System.out.println("userID: "+userId+" "+auth.getName());
		String forward = redirectPageByRole(auth);
                HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		session.setMaxInactiveInterval(7000);
		model.addAttribute("auth", auth);
		if (forward.equals("login"))
			return "login";
		return "redirect:/" + forward + "/dashboard";
	}

	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/user/dashboard")
	public void getUserPage(Model model, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HttpSession session = request.getSession(false);
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			int cartCount = cartDao.CountCartByUserId(userId);
			Double showRate = BitcoinRate.GetBitcoinRate();
			model.addAttribute("bitcoinValue", showRate);
			model.addAttribute("cartCount", cartCount);
			System.out.println("user page is called");
		}
	}

	// private Account checkCookie(HttpServletRequest request) {
	// Cookie cookie[] = request.getCookies();
	// Account account = new Account();
	// String email = "", password = "";
	// if (cookie != null) {
	// for (Cookie cook : cookie) {
	// if (cook.getName().equalsIgnoreCase("email")) {
	// email = cook.getValue();
	// }
	// if (cook.getName().equalsIgnoreCase("password")) {
	// password = cook.getValue();
	// }
	// }
	// if (!email.isEmpty() && !password.isEmpty()) {
	// account.setEmail(email);
	// account.setPassword(password);
	// }
	// return account;
	// }
	// return null;
	// }

	public String redirectPageByRole(Authentication auth) {
		String redirect = auth.getAuthorities().stream().findFirst().get().getAuthority();
		System.out.println("roletype " + redirect);
		if (redirect.equals("ROLE_ADMIN")) {
			return "admin";
		} else if (redirect.equals("ROLE_SUPERADMIN")) {
			return "superAdmin";
		} else if (redirect.equals("ROLE_SUPERUSER")) {
			return "superUser";
		} else if (redirect.equals("ROLE_MODERATOR")) {
			return "moderator";
		} else if (redirect.equals("ROLE_USER")) {
			return "user";
		}
		return "login";
	}

	// @GetMapping("/error")
	// public ModelAndView error() {
	// ModelAndView modelAndView = new ModelAndView();
	// String errorMessage = "You are not authorized for the requested data.";
	// modelAndView.addObject("errorMsg", errorMessage);
	// modelAndView.setViewName("error");
	// return modelAndView;
	// }

	// public Account LoginAttempt(Account account) {
	// Account validate = accountDao.findAccountByEmail(account.getEmail());
	// if (validate != null) {
	// BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	// if (bCryptPasswordEncoder.matches(account.getPassword(),
	// validate.getPassword())
	// && validate.getIsActivated() && !validate.getIsDeleted() &&
	// !validate.getIsBlocked()) {
	// return validate;
	// }
	// }
	// return null;
	// }
}
