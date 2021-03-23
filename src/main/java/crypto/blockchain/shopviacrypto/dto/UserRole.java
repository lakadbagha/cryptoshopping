/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author avatar
 */
@Entity
@Table(name = "AUTHORITIES")
public class UserRole{

    public UserRole() {
	}


	public UserRole(String name) {
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private int id;

    @Column(name = "ROLE_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ICON_IMAGE")
    private String iconImage;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIconImage() {
		return iconImage;
	}


	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}


	public Boolean getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
