package crypto.blockchain.shopviacrypto.bean;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import crypto.blockchain.shopviacrypto.dto.Account;

public class UserDetailsModel extends Account implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2049384917769838481L;

	public UserDetailsModel(Account account) {
		// TODO Auto-generated constructor stub
		super(account);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return getCheckRoletype().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		if(super.getIsDeleted())
			return false;
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		if(super.getIsBlocked())
			return false;
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.getIsActivated();
	}

}
