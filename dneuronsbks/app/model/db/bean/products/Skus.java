package model.db.bean.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name="skus")
public class Skus extends Model{
	

//id VARCHAR(20), 
//name VARCHAR(20),
//status VARCHAR(20), 
//price VARCHAR(20),
//type VARCHAR(20),
//features VARCHAR(100),
//created_date DATE, 
//expiry_date DATE);		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String status;
	private String price;
	private String type;
	private String features;
	private String createdDate;
	private String expiryDate;

	@Id
	//@GeneratedValue(strategy = IDENTITY)
	@Column(name="id")
	public String getId() {
		return this.id;
	}
	@Column(name="name")
	public String getName() {
		return this.name;
	}
	
	@Column(name="status")
	public String getStatus() {
		return this.status;
	}
	
	@Column(name="price")
	public String getPrice() {
		return this.price;
	}
	
	@Column(name="type")
	public String getType() {
		return this.type;
	}
	
	@Column(name="features")
	public String getFeatures() {
		return this.features;
	}
	
	@Column(name="created_date")
	public String getCreatedDate() {
		return this.createdDate;
	}
	
	@Column(name="expiry_date")
	public String getExpiryDate() {
		return this.expiryDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static Finder<Integer, Skus> finder = new Finder<Integer, Skus>(
			Integer.class, Skus.class);
}