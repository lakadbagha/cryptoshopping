/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.blockchain.shopviacrypto.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author avatar
 */
@Entity
@Table(name ="PRODUCT")
public class Product{
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "PRODUCT_ID")
    private Long productId;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PRICE")
    private Float price;
    
    @Column(name = "QUANTITY")
    private Integer Quantity;
    
    @Column(name="MODEL_ID")
    private String modelId;
    
    @Column(name="BRAND_NAME")
    private String brandName;
    
    @Column(name = "WEBSITE_NAME")
    private String websiteName;
    
    @Size(min=10)
    @Column(name = "PRODUCT_URL")
    private String productURL;
    
    @Column(name = "PRODUCT_KEY")
    private Long productKey;
    
    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;
    
    @Column(name = "IS_AVAILABLE")
    private Boolean isAvailable;
    
    @Column(name="CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name="MODIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name="MODIFY_BY")
    private String modifyBy;
    
    @Column(name="IS_DELETED")
    private Boolean isDeleted;
    
    @OneToMany(mappedBy = "product")
    private Set<Cart> cart= new HashSet<>();
            
    /**
     * @return the productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @return the Quantity
     */
    public Integer getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the websiteName
     */
    public String getWebsiteName() {
        return websiteName;
    }

    /**
     * @param websiteName the websiteName to set
     */
    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    /**
     * @return the productURL
     */
    public String getProductURL() {
        return productURL;
    }

    /**
     * @param productURL the productURL to set
     */
    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    /**
     * @return the productKey
     */
    public Long getProductKey() {
        return productKey;
    }

    /**
     * @param productKey the productKey to set
     */
    public void setProductKey(Long productKey) {
        this.productKey = productKey;
    }
    
    public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
     * @return the isAvailable
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * @return the cart
     */
    public Set<Cart> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
    
    
}
