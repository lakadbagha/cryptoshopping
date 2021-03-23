/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.bean;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author avatar
 */
public class LoginInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3909464123516249838L;


    private Long userId;


    @Email
    @NotNull
    @Size(min = 7, max = 100)
    private String email;

    @NotNull
    @Size(min = 3, max = 64)
    private String password;

    

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    

}
