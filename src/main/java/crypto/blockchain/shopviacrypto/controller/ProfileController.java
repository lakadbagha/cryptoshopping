package crypto.blockchain.shopviacrypto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import crypto.blockchain.shopviacrypto.bean.UserInfo;
import crypto.blockchain.shopviacrypto.dao.AccountDao;
import crypto.blockchain.shopviacrypto.dto.Account;

@RestController
public class ProfileController {

	@Autowired
	AccountDao accountDao;

	@GetMapping("/getUserInfo")
	public UserInfo getUserInfo(HttpServletRequest request) {
		UserInfo info = new UserInfo();
		HttpSession session = request.getSession();
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			Account account = accountDao.findById(userId);
			info.setCreatedDate(account.getCreatedDate());
			info.setEmail(account.getEmail());
			info.setUserName(account.getFirstName());
			info.setModifyDate(account.getModifiedDate());
			info.setUserId(account.getUserId());
		}
		return info;
	}

	@GetMapping("/user/userSetting")
	public ModelAndView showUserInfo(HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		view.setViewName("/user/userSetting.html");
		view.addObject("userInfo", getUserInfo(request));
		return view;
	}

	@PostMapping("/user/updateUserInfo")
	public String updateAccount(HttpServletRequest request, @RequestParam String password) {
		
		HttpSession session = request.getSession();
		if (session != null) {
			Long userId = (Long) session.getAttribute("userId");
			Account account = accountDao.findById(userId);
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			account.setPassword(bCryptPasswordEncoder.encode(password));
			account.setModifyBy(userId);
			accountDao.updateAccount(account);
			return "success";
		}
		return "fail";
	}
}
