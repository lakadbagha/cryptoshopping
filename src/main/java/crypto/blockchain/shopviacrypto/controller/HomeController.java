package crypto.blockchain.shopviacrypto.controller;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import crypto.blockchain.shopviacrypto.dao.AccountDao;
import crypto.blockchain.shopviacrypto.dto.Account;
import crypto.blockchain.shopviacrypto.dto.UserRole;

@Controller
public class HomeController {

	@Autowired
	AccountDao accountDao;
	
	@RequestMapping("/")
	public ModelAndView index() {  
		System.out.println("default page is called .....  index");
	    ModelAndView mav= new ModelAndView();
	    mav.setViewName("index");
//	    mav.addObject("loginInfo", new LoginInfo());
	    return mav;
	}
	
	@GetMapping("login")
	public String getLogin() {
		System.out.println("login page called");
		return "login";
	}
	
	@GetMapping("/activate/account/{email}/{key}")
	public String confirmAccount(@PathVariable("email") String email,@PathVariable("key") String key,@RequestParam("id") String userId, Model model) {
		System.out.println("in activate account url "+ userId);
		Account validate= accountDao.findAccountByEmail(email);

		if(validate!=null) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			if(bCryptPasswordEncoder.matches(validate.getUserId().toString(),userId) && validate.getActivationKey().equals(key)) {
				validate.setIsActivated(true);
				validate.setModifyBy(validate.getUserId());
				Calendar cal= Calendar.getInstance();
				Timestamp modifyDate = new Timestamp(cal.getTime().getTime());
				validate.setModifiedDate(modifyDate);
				UserRole checkRoletype= new UserRole();
				checkRoletype.setId(1);
				validate.getCheckRoletype().add(checkRoletype);
				accountDao.updateAccount(validate);
				String topic= "Congrates! Activated Your Account";
				String message = "The please go to 'home page' for login.";
				model.addAttribute("topic", topic);
				model.addAttribute("message", message);
				return "result/message";
			}
		}
		String topic= "Oops! invalid Details";
		String message = "please contact support for help.";
		model.addAttribute("topic", topic);
		model.addAttribute("message", message);
		return "information";
//		return "error";
	}
	
	@GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
