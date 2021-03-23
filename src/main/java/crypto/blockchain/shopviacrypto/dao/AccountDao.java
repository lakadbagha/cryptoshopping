package crypto.blockchain.shopviacrypto.dao;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import crypto.blockchain.shopviacrypto.bean.UserDetailsModel;
import crypto.blockchain.shopviacrypto.dto.Account;
import crypto.blockchain.shopviacrypto.repository.AccountRepository;

@Service
public class AccountDao implements UserDetailsService {

	@Autowired
	AccountRepository accountRepository;

	public Account findAccountByEmail(String email) {
		return accountRepository.findByEmail(email).orElse(null);
	}

	public List<Account> findAllAccount() {
		return accountRepository.findAll();
	}

	public List<Account> findRole(int id) {
		return accountRepository.findByCheckRoletype(id);
	}

	public void saveAccount(Account account) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		account.setCreatedDate(modifiedDate);
		account.setIsActivated(false);
		account.setIsDeleted(false);
		account.setIsBlocked(false);

		accountRepository.save(account);
	}

	public List<Account> findModifyBy(Long modifyBy) {
		return accountRepository.findByModifyBy(modifyBy);
	}

	public Account findById(Long Id) {
		return accountRepository.findById(Id).orElse(null);
	}

	public void updateAccount(Account account) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		account.setModifiedDate(modifiedDate);
		accountRepository.save(account);
	}

	public void deleteAccount(Account account) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		account.setModifiedDate(modifiedDate);
		account.setIsDeleted(true);
		accountRepository.save(account);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account = accountRepository.findByEmail(email).orElse(null);
		if(account == null) {
			throw new UsernameNotFoundException("Username not found.");
		}
		System.out.println("checking authentication");
		return new UserDetailsModel(account);
	}

}
