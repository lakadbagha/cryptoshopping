/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



/**
 *
 * @author avatar
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {


	public Account() {
		
	}
	
public Account(Account account) {
		this.userId = account.getUserId();
		this.email = account.getEmail();
		this.password = account.getPassword();
		this.isActivated = account.getIsActivated();
		this.isBlocked = account.getIsBlocked();
		this.isDeleted = account.getIsDeleted();
		this.checkRoletype = account.getCheckRoletype();
		this.firstName = account.getFirstName();
		this.addresses = account.getAddresses();
		this.carts = account.getCarts();
		this.createdDate = account.getCreatedDate();
		this.lastName = account.getLastName();
		this.modifiedDate = account.getModifiedDate();
		this.modifyBy = account.getModifyBy();
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
	
	
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

//    @Email(message="Write valid email.")
//    @NotEmpty
//    @Size(min = 7, max = 100)
    @Column(name = "EMAIL", unique = true)
    private String email;

//    @NotEmpty
//    @Size(min = 5, max = 64)
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;

    @Column(name = "IS_ACTIVATED")
    private Boolean isActivated;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="USER_ROLE",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> checkRoletype;
    
    @Column(name = "MODIFY_BY")
    private Long modifyBy;

    @Column(name = "ACTIVATION_KEY")
    private String activationKey;

    @Column(name = "IS_BLOCKED")
    private Boolean isBlocked;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
    
    @OneToMany(mappedBy = "account")
    private Set<Address> addresses= new HashSet<>();
    
    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<Cart> carts = new HashSet<>();

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

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Set<UserRole> getCheckRoletype() {
		return checkRoletype;
	}

	public void setCheckRoletype(Set<UserRole> checkRoletype) {
		this.checkRoletype = checkRoletype;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the createdDate
     */
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the modifiedDate
     */
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }
}
